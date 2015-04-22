package com.csc.dao.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.csc.dao.FundDAO;
import com.csc.entities.Account;
import com.csc.entities.State;
import com.csc.entities.StateResult;
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
	public StateResult addFund(String id, BigDecimal amount) {
		StateResult state = new StateResult();
		try {
			Account account = em.find(Account.class, id);
			
			account.setAvailableAmount(account.getAvailableAmount().add(amount));
			
			state.setState(true);
			return state;
		} catch (Exception e) {
			state.setState(false);
			state.setMessage("Can't add fund");
			return state;
		}
	}
	
	@Override
	public StateResult transfer(String sendAccount_ID, String targetAccount_ID,
			BigDecimal amount) {
		Account sendAccount = em.find(Account.class, sendAccount_ID);
		Account targetAccount = em.find(Account.class, targetAccount_ID);
		
		return checkAndTransfer(sendAccount, targetAccount, amount);
	}

	@Override
	public List<TargetAccount> getTargetAccount(String id) {
		try {
			String sql = "SELECT t FROM TargetAccount t WHERE t.accountOwner.id = :id";
			TypedQuery<TargetAccount> query = em.createQuery(sql, TargetAccount.class);
			query.setParameter("id", id);
			
			List<TargetAccount> targetAccounts = query.getResultList();
			
			return targetAccounts;
		} catch (Exception e) {
			return null;
		}
		
	}

	@Override
	public StateResult transferTargetID(String sendAccount_ID, String targetAccount_ID,
			BigDecimal amount) {
		Account sendAccount = em.find(Account.class, sendAccount_ID);
		TargetAccount target = em.find(TargetAccount.class, targetAccount_ID);
		Account targetAccount = target.getAccountTarget();
		
		return checkAndTransfer(sendAccount, targetAccount, amount);
	}
	
	private StateResult checkAndTransfer(Account sendAccount, Account targetAccount, BigDecimal amount) {
		StateResult state = new StateResult();
		
		// if availableAmount - sendAmount < 50000 return false;
		BigDecimal money = sendAccount.getAvailableAmount().subtract(amount);
		if (money.compareTo(BigDecimal.valueOf(50000)) < 0) {
			state.setState(false);
			state.setMessage("The amount in the account is not enough to transfer");
			return state;
		}
		
		// Check state sendAccount
		if (sendAccount.getState().getIdState() != State.ACTIVE) {
			state.setState(false);
			state.setMessage("Account is not ACTIVE");
			return state;
		}
		
		// transfer money
		sendAccount.setAvailableAmount(money);
		
		money = targetAccount.getAvailableAmount().add(amount);
		targetAccount.setAvailableAmount(money);
			
		state.setState(true);
		return state;
	}

	@Override
	public StateResult withdraw(String accountNumber, BigDecimal amount) {
		StateResult state = new StateResult();
		try {
			Account account = em.find(Account.class, accountNumber);
			
			// if availableAmount - amount < 50000 return false;
			BigDecimal money = account.getAvailableAmount().subtract(amount);
			if (money.compareTo(BigDecimal.valueOf(50000)) < 0) {
				state.setState(false);
				state.setMessage("The amount in the account is not enough to withdraw");
				return state;
			}
			
			// Check state sendAccount
			if (account.getState().getIdState() != State.ACTIVE) {
				state.setState(false);
				state.setMessage("Account is not ACTIVE");
				return state;
			}
		
			account.setAvailableAmount(money);
			
			state.setState(true);
			return state;
		} catch (Exception e) {
			state.setState(false);
			state.setMessage("Error");
			return state;
		}
	}

}
