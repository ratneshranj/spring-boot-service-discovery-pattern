package com.card.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.card.model.Card;
import com.card.repository.CardRepository;

@Controller
public class CardController {
	
	@Autowired
	private CardRepository cardsRepository;
	
	@GetMapping("/myCards/{customerId}")
	public @ResponseBody List<Card> getCardDetails(@PathVariable("customerId") int customerId) {
		return cardsRepository.findByCustomerId(customerId);
	}
}
