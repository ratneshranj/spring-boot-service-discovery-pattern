package com.account.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class CustomerDetails {
	private Accounts account;
	private List<Loans> loans;
	private List<Card> card;
	public Accounts getAccount() {
		return account;
	}
	public void setAccount(Accounts account) {
		this.account = account;
	}
	public List<Loans> getLoans() {
		return loans;
	}
	public void setLoans(List<Loans> loans) {
		this.loans = loans;
	}
	public List<Card> getCard() {
		return card;
	}
	public void setCard(List<Card> card) {
		this.card = card;
	}
	
	
}
