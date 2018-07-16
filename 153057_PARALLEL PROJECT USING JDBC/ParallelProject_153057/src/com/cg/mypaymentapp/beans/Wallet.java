package com.cg.mypaymentapp.beans;

import java.math.BigDecimal;

public class Wallet {
	private BigDecimal balance;
	
	

	public Wallet(BigDecimal balance) {
		super();
		this.balance = balance;
	}

	public Wallet() {
		// TODO Auto-generated constructor stub
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Wallet [balance=" + balance + "]";
	}
	
}
