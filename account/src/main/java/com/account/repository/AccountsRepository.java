package com.account.repository;

import org.springframework.data.repository.CrudRepository;

import com.account.model.Accounts;

public interface AccountsRepository extends CrudRepository<Accounts, Long> {

	Accounts findByCustomerId(int customerId);
}
