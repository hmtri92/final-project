package com.csc.service;

import java.math.BigDecimal;
import java.util.List;

import com.csc.entities.Account;
import com.csc.entities.TargetAccount;
import com.csc.entities.Transaction;


public interface FundService {
	boolean addFund(String id, BigDecimal amount);
	Account getAccountById(String accountNumber);
	boolean transfer(String sendAccount_ID, String targetAccount_ID,
			BigDecimal amount);
	List<TargetAccount> getTargetAccount(String id);
	boolean transferTargetID(String sendAccount_ID, String targetAccount_ID, BigDecimal amount);
	boolean withdraw(String accountNumber, BigDecimal amount);
	List<Transaction> getNewTransaction();
	boolean verifyTransaction(long idTransaction);
}

