package com.csc.dao;

import java.math.BigDecimal;
import java.util.List;

import com.csc.entities.Account;
import com.csc.entities.StateResult;
import com.csc.entities.TargetAccount;

/**
 * 
 * @author MinhTri
 *
 */
public interface FundDAO {
	
	/**
	 * addfund to account with amount
	 * @param account
	 * @param amount
	 * @return StateResult
	 */
	StateResult addFund(Account account, BigDecimal amount);
	
	/**
	 * transfer amount money from sendAcount to targetAccount
	 * @param sendAccount
	 * @param targetAccount
	 * @param amount
	 * @return StateResult
	 */
	StateResult transfer(Account sendAccount, Account targetAccount, BigDecimal amount);
	
	/**
	 * get targetAccount by id
	 * @param id
	 * @return List<TargetAccount>
	 */
	List<TargetAccount> getTargetAccount(String id);
	
	/**
	 * withdraw amount money from account
	 * @param account
	 * @param amount
	 * @return StateResult
	 */
	StateResult withdraw(Account account, BigDecimal amount);
	
}
