package com.csc.dao.impl;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.csc.dao.FundDAO;
import com.csc.entities.Account;
import com.csc.entities.State;
import com.csc.entities.Transaction;

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
	@Transactional
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
	@Transactional
	public boolean transferBySupport(String sendAccount, String targetAccount,
			BigDecimal amount) {
		Account sendAccount_ = em.find(Account.class, sendAccount);
		Account targetAccount_ = em.find(Account.class, targetAccount);
		
		// if availableAmount - sendAmount < 50000 return false;
		BigDecimal money = sendAccount_.getAvailableAmount().subtract(amount);
		if (money.compareTo(BigDecimal.valueOf(50000)) < 0) {
			return false;
		}
		
		// Check state sendAccount
		if (sendAccount_.getState().getIdState() != State.ACTIVE) {
			return false;
		}
		
		// transfer money
		sendAccount_.setAvailableAmount(money);
		
		money = targetAccount_.getAvailableAmount().add(amount);
		targetAccount_.setAvailableAmount(money);
			
		return true;
	}

	@Override
	@Transactional
	public boolean transferTransaction(String sendAccount,
			String targetAccount, BigDecimal amount) {
		Account sendAccount_ = em.find(Account.class, sendAccount);
		Account targetAccount_ = em.find(Account.class, targetAccount);
		
		Transaction transfer = new Transaction();
		transfer.setDate(new Date());
		transfer.setReceiveAccount(targetAccount_);
		transfer.setSendAccount(sendAccount_);
		transfer.setAmount(amount);
		
		String content = "Tranfer from " + sendAccount_.getId() + " to " + targetAccount_.getId() + ": " + amount;
		transfer.setContent(content);
		em.persist(transfer);
		
		return true;
	}

}
