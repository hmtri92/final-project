package com.csc.dao.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.csc.dao.FundDAO;
import com.csc.entities.Account;
import com.csc.entities.StateResult;
import com.csc.entities.TargetAccount;

/**
 * 
 * @author MinhTri
 *
 */
@Repository
public class FundDAOImpl implements FundDAO {

	@PersistenceContext
	EntityManager em;
	
	/*
	 * (non-Javadoc)
	 * @see com.csc.dao.FundDAO#addFund(com.csc.entities.Account, java.math.BigDecimal)
	 */
	@Override
	public StateResult addFund(Account account, BigDecimal amount) {
		StateResult state = new StateResult();
		try {
			account.setAvailableAmount(account.getAvailableAmount().add(amount));
			
			state.setState(true);
			state.setMessage("Success");
		} catch (NullPointerException e) {
			// field availableAmount null
			account.setAvailableAmount(amount);
		} catch (Exception e) {
			state.setState(false);
			state.setMessage("Can't add fund");
		}
		return state;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.csc.dao.FundDAO#transfer(com.csc.entities.Account, com.csc.entities.Account, java.math.BigDecimal)
	 */
	@Override
	public StateResult transfer(Account sendAccount, Account targetAccount, BigDecimal amount) {
		StateResult state = new StateResult();
		
		BigDecimal money = new BigDecimal(0);
		try {
			money = sendAccount.getAvailableAmount().subtract(amount);
		} catch (NullPointerException e) {}
		
		// transfer money
		sendAccount.setAvailableAmount(money);
		try {
			money = targetAccount.getAvailableAmount().add(amount);
		} catch (NullPointerException e) {
			money = amount;
		}
		targetAccount.setAvailableAmount(money);
			
		state.setState(true);
		return state;
	}

	/*
	 * (non-Javadoc)
	 * @see com.csc.dao.FundDAO#getTargetAccount(java.lang.String)
	 */
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

	/*
	 * (non-Javadoc)
	 * @see com.csc.dao.FundDAO#withdraw(com.csc.entities.Account, java.math.BigDecimal)
	 */
	@Override
	public StateResult withdraw(Account account, BigDecimal amount) {
		StateResult state = new StateResult();
		try {
			// if availableAmount - amount < 50000 return false;
			BigDecimal money = new BigDecimal(0);
			try {
				money = account.getAvailableAmount().subtract(amount);
			} catch (NullPointerException e) {}
		
			account.setAvailableAmount(money);
			
			state.setState(true);
			state.setMessage("Success");
			return state;
		} catch (Exception e) {
			state.setState(false);
			state.setMessage("Error");
			return state;
		}
	}

}
