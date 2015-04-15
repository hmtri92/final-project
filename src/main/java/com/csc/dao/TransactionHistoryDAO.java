package com.csc.dao;

import java.math.BigDecimal;
import java.util.List;

import com.csc.entities.Transaction;

public interface TransactionHistoryDAO {
	boolean addFundTransaction(String id, BigDecimal amount);
	
	boolean transferTransaction(String sendAccount_ID, String targetAccount_ID,
			BigDecimal amount);
	
	boolean withdrawTransaction(String accountNumber, BigDecimal amount);
	
	List<Transaction> getNewTransaction();
	
	boolean transferTransactionTargetID(String sendAccount_ID,
			String targetAccount_ID, BigDecimal amount);

	Transaction getTransaction(long idTransaction);
	
	boolean changeStateTransaction(long idTransaction);
}
