package com.csc.beans;

import java.io.Serializable;

public class BalanceAmountBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String idBalanceAmount;
	
	private float balance;

	private int period;
	
	private AccountBean account;

	public BalanceAmountBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BalanceAmountBean(String idBalanceAmount, float balance, int period,
			AccountBean account) {
		super();
		this.idBalanceAmount = idBalanceAmount;
		this.balance = balance;
		this.period = period;
		this.account = account;
	}

	public String getIdBalanceAmount() {
		return idBalanceAmount;
	}

	public void setIdBalanceAmount(String idBalanceAmount) {
		this.idBalanceAmount = idBalanceAmount;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	public AccountBean getAccount() {
		return account;
	}

	public void setAccount(AccountBean account) {
		this.account = account;
	}
}
