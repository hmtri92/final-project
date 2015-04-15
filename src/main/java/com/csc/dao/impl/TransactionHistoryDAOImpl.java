package com.csc.dao.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.csc.dao.TransactionHistoryDAO;
import com.csc.entities.Account;
import com.csc.entities.State;
import com.csc.entities.TargetAccount;
import com.csc.entities.Transaction;

@Repository
public class TransactionHistoryDAOImpl implements TransactionHistoryDAO {

	@PersistenceContext
	EntityManager em;
	
	@Override
	public boolean addFundTransaction(String id, BigDecimal amount) {
		Account account = em.find(Account.class, id);
		State newState = em.find(State.class, State.NEW);
		
		Transaction add = new Transaction();
		add.setDate(new Date());
		add.setReceiveAccount(account);
		add.setSendAccount(account);
		add.setAmount(amount);
		add.setState(newState);
		add.setTypeTransaction(Transaction.ADD_FUND);
		
		String content = "Add " + amount;
		add.setContent(content);
		em.persist(add);
		
		return true;
	}

	@Override
	public boolean transferTransaction(String sendAccount_ID,
			String targetAccount_ID, BigDecimal amount) {
		Account sendAccount = em.find(Account.class, sendAccount_ID);
		Account targetAccount = em.find(Account.class, targetAccount_ID);
		
		return saveTransfer(sendAccount, targetAccount, amount);	
	}
	
	@Override
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
		transfer.setTypeTransaction(Transaction.TRANSFER);
		
		String content = "Tranfer from " + sendAccount.getId() + " to " + targetAccount.getId() + ": " + amount;
		transfer.setContent(content);
		em.persist(transfer);
		
		return true;
	}

	@Override
	public boolean withdrawTransaction(String accountNumber, BigDecimal amount) {
		Account account = em.find(Account.class, accountNumber);
		State newState = em.find(State.class, State.NEW);
		
		Transaction withdraw = new Transaction();
		withdraw.setDate(new Date());
		withdraw.setReceiveAccount(account);
		withdraw.setSendAccount(account);
		withdraw.setAmount(amount);
		withdraw.setState(newState);
		withdraw.setTypeTransaction(Transaction.WITHDRAW);
		
		String content = "Withdraw " + amount;
		withdraw.setContent(content);
		em.persist(withdraw);
		
		return true;
	}

	@Override
	public List<Transaction> getNewTransaction() {
		String sql = "SELECT t FROM Transaction t WHERE t.state.idState = :state";
		TypedQuery<Transaction> query = em.createQuery(sql, Transaction.class);
		query.setParameter("state", State.NEW);
		
		List<Transaction> transactions = query.getResultList();
		return transactions;
	}

	@Override
	public Transaction getTransaction(long idTransaction) {
		return em.find(Transaction.class, idTransaction);
	}
	
	@Override
	public boolean changeStateTransaction(long idTransaction) {
		String sql = "UPDATE logTransaction t SET state = :state WHERE t.id_Transaction = :id";
		em.createNativeQuery(sql).setParameter("state", State.ACTIVE)
				.setParameter("id", idTransaction)
				.executeUpdate();
		
		return true;
	}

}
