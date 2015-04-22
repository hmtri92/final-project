package com.csc.service;

import java.math.BigDecimal;
import java.util.List;

import com.csc.entities.Account;
import com.csc.entities.StateResult;
import com.csc.entities.TargetAccount;
import com.csc.entities.Transaction;


public interface FundService {
	boolean addFund(String id, BigDecimal amount);
	Account getAccountById(String accountNumber);
	StateResult transfer(String sendAccount_ID, String targetAccount_ID,
			BigDecimal amount);
	List<TargetAccount> getTargetAccount(String id);
	StateResult transferTargetID(String sendAccount_ID, String targetAccount_ID, BigDecimal amount);
	StateResult withdraw(String accountNumber, BigDecimal amount);
	List<Transaction> getNewTransaction();
	StateResult verifyTransaction(long idTransaction);
	List<TargetAccount> getListTargetByAccountOwnerId(String id);
}

