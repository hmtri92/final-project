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
import com.csc.entities.StateResult;
import com.csc.entities.TargetAccount;
import com.csc.entities.TransactionHistory;

@Repository
public class TransactionHistoryDAOImpl implements TransactionHistoryDAO {

	@PersistenceContext
	EntityManager em;
	
	@Override
	public boolean addFundTransaction(String id, BigDecimal amount) {
		Account account = em.find(Account.class, id);
		State newState = em.find(State.class, State.NEW);
		
		TransactionHistory add = new TransactionHistory();
		add.setDate(new Date());
		add.setReceiveAccount(account);
		add.setSendAccount(account);
		add.setAmount(amount);
		add.setState(newState);
		add.setTypeTransaction(TransactionHistory.ADD_FUND);
		
		String content = "Add " + amount;
		add.setContent(content);
		em.persist(add);
		
		return true;
	}

	@Override
	public StateResult transferTransaction(String sendAccount_ID,
			String targetAccount_ID, BigDecimal amount) {
		StateResult state = new StateResult();
		
		Account sendAccount = em.find(Account.class, sendAccount_ID);
		
		// if availableAmount - sendAmount < 50000 return false;
		try {
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
		} catch (NullPointerException e) {
			state.setMessage("The amount in the account is not enough to transfer");
			return state;
		}
		
		Account targetAccount = em.find(Account.class, targetAccount_ID);
		
		return saveTransfer(sendAccount, targetAccount, amount);	
	}
	
	@Override
	public StateResult transferTransactionTargetID(String sendAccount_ID,
			String targetAccount_ID, BigDecimal amount) {
		StateResult state = new StateResult();
		
		Account sendAccount = em.find(Account.class, sendAccount_ID);
		
		long idtarget = Long.parseLong(targetAccount_ID);
		TargetAccount target = em.find(TargetAccount.class, idtarget);
		
		// if availableAmount - sendAmount < 50000 return false;
		try {
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
		} catch (NullPointerException e) {
			state.setMessage("The amount in the account is not enough to transfer");
			return state;
		}
		Account targetAccount = target.getAccountTarget();
		
		return saveTransfer(sendAccount, targetAccount, amount);	
	}
	
	private StateResult saveTransfer(Account sendAccount, Account targetAccount, BigDecimal amount) {
		StateResult state = new StateResult();
		State newState = em.find(State.class, State.NEW);
		
		TransactionHistory transfer = new TransactionHistory();
		transfer.setDate(new Date());
		transfer.setReceiveAccount(targetAccount);
		transfer.setSendAccount(sendAccount);
		transfer.setAmount(amount);
		transfer.setState(newState);
		transfer.setTypeTransaction(TransactionHistory.TRANSFER);
		
		String content = "Tranfer from " + sendAccount.getId() + " to " + targetAccount.getId() + ": " + amount;
		transfer.setContent(content);
		em.persist(transfer);
		
		state.setState(true);
		state.setMessage("Success");
		return state;
	}

	@Override
	public StateResult withdrawTransaction(String accountNumber, BigDecimal amount) {
		StateResult state = new StateResult();
		Account account = em.find(Account.class, accountNumber);
		State newState = em.find(State.class, State.NEW);
		
		// if availableAmount - sendAmount < 50000 return false;
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
		
		TransactionHistory withdraw = new TransactionHistory();
		withdraw.setDate(new Date());
		withdraw.setReceiveAccount(account);
		withdraw.setSendAccount(account);
		withdraw.setAmount(amount);
		withdraw.setState(newState);
		withdraw.setTypeTransaction(TransactionHistory.WITHDRAW);
		
		String content = "Withdraw " + amount;
		withdraw.setContent(content);
		em.persist(withdraw);
		
		state.setState(true);
		state.setMessage("success");
		return state;
	}

	@Override
	public List<TransactionHistory> getNewTransaction() {
		String sql = "SELECT t FROM TransactionHistory t WHERE t.state.idState = :state";
		TypedQuery<TransactionHistory> query = em.createQuery(sql, TransactionHistory.class);
		query.setParameter("state", State.NEW);
		
		List<TransactionHistory> transactions = query.getResultList();
		return transactions;
	}

	@Override
	public TransactionHistory getTransaction(long idTransaction) {
		return em.find(TransactionHistory.class, idTransaction);
	}
	
	@Override
	public StateResult changeStateTransaction(long idTransaction, int idState) {
		StateResult result = new StateResult();
		try {
			String sql = "UPDATE TransactionHistories t SET state = :state WHERE t.id_Transaction = :id";
			em.createNativeQuery(sql)
				.setParameter("state", idState)
				.setParameter("id", idTransaction)
				.executeUpdate();
			
			result.setState(true);
			result.setMessage("Success");
		} catch (Exception e) {
			result.setState(false);
			result.setMessage("Fail");
		}
		return result;
	}

}
