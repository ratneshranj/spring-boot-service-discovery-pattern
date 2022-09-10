package com.loans.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.loans.model.Loans;
import com.loans.repository.LoansRepository;

@Controller
public class LoansController {
	
	@Autowired
	private LoansRepository loansRepository;
	
	@GetMapping("/myLoans/{customerId}")
	public @ResponseBody List<Loans> getLoansDetails(@PathVariable("customerId") int customerId) {
		return loansRepository.findByCustomerIdOrderByStartDtDesc(customerId);
	}

}
