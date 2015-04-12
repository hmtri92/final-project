package com.csc.dao;

import java.math.BigDecimal;
import java.util.List;

import com.csc.entities.Account;
import com.csc.entities.TargetAccount;

public interface FundDAO {
	boolean addFund(String id, BigDecimal amount);
	boolean addFundTransaction(String id, BigDecimal amount);
	Account getAccountById(String accountNumber);
	boolean transfer(String sendAccount_ID, String targetAccount_ID,
			BigDecimal amount);
	boolean transferTransaction(String sendAccount_ID, String targetAccount_ID,
			BigDecimal amount);
	List<TargetAccount> getTargetAccount(String id);
	boolean transferTargetID(String sendAccount_ID, String targetAccount_ID,
			BigDecimal amount);
	boolean transferTransactionTargetID(String sendAccount_ID,
			String targetAccount_ID, BigDecimal amount);
}
