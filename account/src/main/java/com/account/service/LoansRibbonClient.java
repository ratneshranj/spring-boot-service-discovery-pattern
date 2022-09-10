package com.account.service;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.account.model.Loans;


@RibbonClient("loans")
public interface LoansRibbonClient {
	@RequestMapping(method = RequestMethod.GET,path = "/myLoans/{customerId}",consumes = "application/json")
	@ResponseBody List<Loans> findByCustomerIdOrderByStartDtDesc(@PathVariable("customerId")int customerId);
}
