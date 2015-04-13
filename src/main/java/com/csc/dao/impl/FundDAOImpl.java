package com.csc.dao.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.csc.dao.FundDAO;
import com.csc.entities.Account;
import com.csc.entities.State;
import com.csc.entities.TargetAccount;
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
		State newState = em.find(State.class, State.NEW);
		
		Transaction add = new Transaction();
		add.setDate(new Date());
		add.setReceiveAccount(account);
		add.setSendAccount(account);
		add.setAmount(amount);
		add.setState(newState);
		
		String content = "Add " + amount;
		add.setContent(content);
		em.persist(add);
		
		return true;
	}

	@Override
	@Transactional
	public boolean transfer(String sendAccount_ID, String targetAccount_ID,
			BigDecimal amount) {
		Account sendAccount = em.find(Account.class, sendAccount_ID);
		Account targetAccount = em.find(Account.class, targetAccount_ID);
		
		return checkAndTransfer(sendAccount, targetAccount, amount);
	}

	@Override
	@Transactional
	public boolean transferTransaction(String sendAccount_ID,
			String targetAccount_ID, BigDecimal amount) {
		Account sendAccount = em.find(Account.class, sendAccount_ID);
		Account targetAccount = em.find(Account.class, targetAccount_ID);
		
		return saveTransfer(sendAccount, targetAccount, amount);
	}
	
	@Override
	@Transactional
	public boolean transferTransactionTargetID(String sendAccount_ID,
			String targetAccount_ID, BigDecimal amount) {
		Account sendAccount = em.find(Account.class, sendAccount_ID);
		TargetAccount target = em.find(TargetAccount.class, targetAccount_ID);
		Account targetAccount = target.getAccountTarget();
		
		return saveTransfer(sendAccount, targetAccount, amount);		
	}
	
	private boolean saveTransfer(Account sendAccount, Account targetAccount, BigDecimal amount) {
		State newState = em.find(State.class, State.NEW);
		
		Transaction transfer = new Transaction();
		transfer.setDate(new Date());
		transfer.setReceiveAccount(targetAccount);
		transfer.setSendAccount(sendAccount);
		transfer.setAmount(amount);
		transfer.setState(newState);
		
		String content = "Tranfer from " + sendAccount.getId() + " to " + targetAccount.getId() + ": " + amount;
		transfer.setContent(content);
		em.persist(transfer);
		
		return true;
	}

	@Override
	@Transactional
	public List<TargetAccount> getTargetAccount(String id) {
		Account account = em.find(Account.class, id);
		return account.getTargetAccounts();
	}

	@Override
	@Transactional
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
	@Transactional
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

	@Override
	@Transactional
	public boolean withdrawTransaction(String accountNumber, BigDecimal amount) {
		Account account = em.find(Account.class, accountNumber);
		State newState = em.find(State.class, State.NEW);
		
		Transaction withdraw = new Transaction();
		withdraw.setDate(new Date());
		withdraw.setReceiveAccount(account);
		withdraw.setSendAccount(account);
		withdraw.setAmount(amount);
		withdraw.setState(newState);
		
		String content = "Withdraw " + amount;
		withdraw.setContent(content);
		em.persist(withdraw);
		
		return true;
	}

}
