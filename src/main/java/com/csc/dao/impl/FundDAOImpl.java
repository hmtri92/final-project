package com.csc.dao.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.csc.dao.FundDAO;
import com.csc.entities.Account;
import com.csc.entities.State;
import com.csc.entities.TargetAccount;

@Repository
public class FundDAOImpl implements FundDAO {

	@PersistenceContext
	EntityManager em;
	
	@Override
	public Account getAccountById(String accountNumber) {
		Account account = em.find(Account.class, accountNumber);
		return account;
	}
	
	@Override
	public boolean addFund(String id, BigDecimal amount) {
		try {
			Account account = em.find(Account.class, id);
			
			account.setAvailableAmount(account.getAvailableAmount().add(amount));
			
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	@Override
	public boolean transfer(String sendAccount_ID, String targetAccount_ID,
			BigDecimal amount) {
		Account sendAccount = em.find(Account.class, sendAccount_ID);
		Account targetAccount = em.find(Account.class, targetAccount_ID);
		
		return checkAndTransfer(sendAccount, targetAccount, amount);
	}

	@Override
	public List<TargetAccount> getTargetAccount(String id) {
		Account account = em.find(Account.class, id);
		return account.getTargetAccounts();
	}

	@Override
	public boolean transferTargetID(String sendAccount_ID, String targetAccount_ID,
			BigDecimal amount) {
		Account sendAccount = em.find(Account.class, sendAccount_ID);
		TargetAccount target = em.find(TargetAccount.class, targetAccount_ID);
		Account targetAccount = target.getAccountTarget();
		
		return checkAndTransfer(sendAccount, targetAccount, amount);
	}
	
	private boolean checkAndTransfer(Account sendAccount, Account targetAccount, BigDecimal amount) {

		// if availableAmount - sendAmount < 50000 return false;
		BigDecimal money = sendAccount.getAvailableAmount().subtract(amount);
		if (money.compareTo(BigDecimal.valueOf(50000)) < 0) {
			return false;
		}
		
		// Check state sendAccount
		if (sendAccount.getState().getIdState() != State.ACTIVE) {
			return false;
		}
		
		// transfer money
		sendAccount.setAvailableAmount(money);
		
		money = targetAccount.getAvailableAmount().add(amount);
		targetAccount.setAvailableAmount(money);
			
		return true;
	}

	@Override
	public boolean withdraw(String accountNumber, BigDecimal amount) {
		try {
			Account account = em.find(Account.class, accountNumber);
			
			// if availableAmount - amount < 50000 return false;
			BigDecimal money = account.getAvailableAmount().subtract(amount);
			if (money.compareTo(BigDecimal.valueOf(50000)) < 0) {
				return false;
			}
			
			// Check state sendAccount
			if (account.getState().getIdState() != State.ACTIVE) {
				return false;
			}
		
			account.setAvailableAmount(money);
			
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
