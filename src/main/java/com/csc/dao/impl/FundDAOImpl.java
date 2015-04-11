package com.csc.dao.impl;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.csc.dao.FundDAO;
import com.csc.entities.Account;
import com.csc.entities.Transaction;

@Repository
public class FundDAOImpl implements FundDAO {

	@PersistenceContext
	EntityManager em;
	
	@Override
	@Transactional
	public boolean addFund(String id, BigDecimal amount) {
		try {
			Account account = em.find(Account.class, id);
			
			account.setAvailableAmount(account.getAvailableAmount().add(amount));
//			saveAddFundTransaction(account, amount);
			
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	@Override
	@Transactional
	public boolean addFundTransaction(String id, BigDecimal amount) {
		Account account = em.find(Account.class, id);
		
		Transaction add = new Transaction();
		add.setDate(new Date());
		add.setReceiveAccount(account);
		add.setSendAccount(account);
		add.setAmount(amount);
		
		String content = "Add " + amount;
		add.setContent(content);
		em.persist(add);
		
		return true;
	}

	@Override
	public Account getAccountById(String accountNumber) {
		Account account = em.find(Account.class, accountNumber);
		return account;
	}

}
