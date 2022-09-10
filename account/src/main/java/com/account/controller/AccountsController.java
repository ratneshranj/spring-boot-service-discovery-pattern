package com.account.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.account.model.Accounts;
import com.account.model.Card;
import com.account.model.CustomerDetails;
import com.account.model.Loans;
import com.account.repository.AccountsRepository;
import com.account.service.CardsRibbonClient;
import com.account.service.LoansRibbonClient;

@Controller
public class AccountsController {
	
	@Autowired
	private AccountsRepository accountsRepository;
	
	@LoadBalanced
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Autowired
	RestTemplate restTemplate;	
	
	@GetMapping("/myAccount/{customerId}")
	public @ResponseBody Accounts getAccountDetails(@PathVariable("customerId") int customerId) {
		return accountsRepository.findByCustomerId(customerId);
	}
	
	@GetMapping("/myCustomerDetails/{customerId}")
	public CustomerDetails myCustomerDetails(@PathVariable("customerId") int customerId) {
		Accounts accounts = accountsRepository.findByCustomerId(customerId);
		List<Card> card = this.restTemplate.getForObject("http://card/myCards/"+customerId, List.class);
		//List<Loans> loans = this.restTemplate.getForObject("http://loans/myCards/"+customerId, List.class);

		CustomerDetails customerDetails = new CustomerDetails();
		customerDetails.setAccount(accounts);
		//customerDetails.setLoans(loans);
		customerDetails.setCard(card);
		
		return customerDetails;
	}

}
