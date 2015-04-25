package com.csc.dao;

import java.math.BigDecimal;
import java.util.List;

import com.csc.entities.StateResult;
import com.csc.entities.TransactionHistory;

public interface TransactionHistoryDAO {
	boolean addFundTransaction(String id, BigDecimal amount);
	
	StateResult transferTransaction(String sendAccount_ID, String targetAccount_ID,
			BigDecimal amount);
	
	StateResult withdrawTransaction(String accountNumber, BigDecimal amount);
	
	List<TransactionHistory> getNewTransaction();
	
	StateResult transferTransactionTargetID(String sendAccount_ID,
			String targetAccount_ID, BigDecimal amount);

	TransactionHistory getTransaction(long idTransaction);
	
	StateResult changeStateTransaction(long idTransaction, int idState);
}
