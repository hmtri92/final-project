package com.csc.dao;

import java.math.BigDecimal;

import com.csc.entities.Account;

public interface FundDAO {
	boolean addFund(String id, BigDecimal amount);
	boolean addFundTransaction(String id, BigDecimal amount);
	Account getAccountById(String accountNumber);
	boolean transferBySupport(String sendAccount, String targetAccount,
			BigDecimal amount);
	boolean transferTransaction(String sendAccount, String targetAccount,
			BigDecimal amount);
}
