package com.csc.dao;

import java.math.BigDecimal;
import java.util.List;

import com.csc.entities.StateResult;
import com.csc.entities.Transaction;

public interface TransactionHistoryDAO {
	boolean addFundTransaction(String id, BigDecimal amount);
	
	StateResult transferTransaction(String sendAccount_ID, String targetAccount_ID,
			BigDecimal amount);
	
	StateResult withdrawTransaction(String accountNumber, BigDecimal amount);
	
	List<Transaction> getNewTransaction();
	
	StateResult transferTransactionTargetID(String sendAccount_ID,
			String targetAccount_ID, BigDecimal amount);

	Transaction getTransaction(long idTransaction);
	
	boolean changeStateTransaction(long idTransaction);
}
