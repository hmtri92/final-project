package com.csc.dao;

import java.math.BigDecimal;
import java.util.List;

import com.csc.entities.Account;
import com.csc.entities.StateResult;
import com.csc.entities.TransactionHistory;

/**
 * 
 * @author MinhTri
 *
 */
public interface TransactionHistoryDAO {
	/**
	 * add transaction is addfund
	 * @param id
	 * @param amount
	 * @return StateResult
	 */
	StateResult addFundTransaction(String id, BigDecimal amount);
	
	/**
	 * add transaction is withdraw
	 * @param account
	 * @param amount
	 * @return StateResult
	 */
	StateResult withdrawTransaction(Account account, BigDecimal amount);
	
	/**
	 * get transaction new state
	 * @return List<TransactionHistory>
	 */
	List<TransactionHistory> getNewTransaction();
	
	/**
	 * get transaction by id
	 * @param idTransaction
	 * @return TransactionHistory
	 */
	TransactionHistory getTransaction(long idTransaction);
	
	/**
	 * change state transaction new -> active or new -> disable
	 * @param transaction
	 * @param idState
	 * @return StateResult
	 */
	StateResult changeStateTransaction(TransactionHistory transaction, int idState);
	
	/**
	 * create transaction transfer
	 * @param sendAccount
	 * @param targetAccount
	 * @param amount
	 * @return StateResult
	 */
	StateResult saveTransfer(Account sendAccount, Account targetAccount, BigDecimal amount);
}
