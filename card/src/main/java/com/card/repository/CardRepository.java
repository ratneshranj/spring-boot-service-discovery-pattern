package com.card.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.card.model.Card;

public interface CardRepository extends CrudRepository<Card, Long> {
	
	List<Card> findByCustomerId(int customerId);

}
