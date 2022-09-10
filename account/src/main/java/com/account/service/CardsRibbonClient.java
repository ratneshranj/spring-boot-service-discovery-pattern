package com.account.service;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.account.model.Card;


@RibbonClient("card")
public interface CardsRibbonClient {
	@RequestMapping(method = RequestMethod.GET,path = "/myCards/{customerId}",consumes = "application/json")
	@ResponseBody List<Card> findByCustomerId(@PathVariable("customerId")int customerId);
}
