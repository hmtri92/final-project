package com.csc.service.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csc.dao.AccountDAO;
import com.csc.dao.FundDAO;
import com.csc.dao.ITargetAccountDAO;
import com.csc.dao.TransactionHistoryDAO;
import com.csc.entities.Account;
import com.csc.entities.StateResult;
import com.csc.entities.TargetAccount;
import com.csc.entities.Transaction;
import com.csc.service.FundService;

@Service
public class FundServiceImpl implements FundService {

	@Autowired
	FundDAO fundDao;
	
	@Autowired
	TransactionHistoryDAO transactionDao;
	
	@Autowired
	ITargetAccountDAO targetAccountDao;
	
	@Autowired
	AccountDAO accountDao;
	
	@Override
	@Transactional
	public boolean addFund(String id, BigDecimal amount) {
		return transactionDao.addFundTransaction(id, amount);
	}

	@Override
	@Transactional
	public Account getAccountById(String accountNumber) {
		return fundDao.getAccountById(accountNumber);
	}

	@Override
	@Transactional
	public StateResult transfer(String sendAccount_ID, String targetAccount_ID,
			BigDecimal amount) {
		StateResult result = new StateResult();
		Account account = accountDao.getAccountById(targetAccount_ID);
				
		if (account == null) {
			result.setState(false);
			result.setMessage("Account not fund!");
			return result;
		}
		return transactionDao.transferTransaction(sendAccount_ID, targetAccount_ID, amount);
	}

	@Override
	@Transactional
	public List<TargetAccount> getTargetAccount(String id) {
		return fundDao.getTargetAccount(id);
	}

	@Override
	@Transactional
	public StateResult transferTargetID(String sendAccount_ID, String targetAccount_ID,
			BigDecimal amount) {
		StateResult result = new StateResult();
		return transactionDao.transferTransactionTargetID(sendAccount_ID, targetAccount_ID, amount);
	}

	@Override
	@Transactional
	public StateResult withdraw(String accountNumber, BigDecimal amount) {
		return transactionDao.withdrawTransaction(accountNumber, amount);
	}

	@Override
	@Transactional
	public List<Transaction> getNewTransaction() {
		return transactionDao.getNewTransaction();
	}

	@Override
	@Transactional
	public StateResult verifyTransaction(long idTransaction) {
		Transaction transaction = transactionDao.getTransaction(idTransaction);
		StateResult result = new StateResult();
		
		if (transaction.getTypeTransaction() == Transaction.ADD_FUND)
		{
			result = fundDao.addFund(transaction.getSendAccount().getId(), transaction.getAmount());
		} else if (transaction.getTypeTransaction() == Transaction.TRANSFER) {
			
			result = fundDao.transfer(transaction.getSendAccount().getId(), 
					transaction.getReceiveAccount().getId(), transaction.getAmount());
		} else {
			result = fundDao.withdraw(transaction.getSendAccount().getId(), transaction.getAmount());
		}
		
		if (result.getState()) {
			transactionDao.changeStateTransaction(transaction.getIdTransaction());
		}
		
		return result;
	}

	@Override
	public List<TargetAccount> getListTargetByAccountOwnerId(String id) {
		return targetAccountDao.getListTargetByAccountOwnerId(id);
	}

	@Override
	@Transactional
	public StateResult addTargetAccount(String idAccountOwner,
			String idAccountTarget, String name) {
		StateResult result = new StateResult();
		
		Account account = accountDao.getAccountById(idAccountTarget);
		if (account == null) {
			result.setState(false);
			result.setMessage("Account not fund!");
			return result;
		}
		
		return targetAccountDao.addTargetAccount(idAccountOwner, idAccountTarget, name);
	}

	@Override
	@Transactional
	public StateResult modifyTarget(String id, String idAccountTarget,
			String name) {
StateResult result = new StateResult();
		
		Account account = accountDao.getAccountById(idAccountTarget);
		if (account == null) {
			result.setState(false);
			result.setMessage("Account not fund!");
			return result;
		}
		
		return targetAccountDao.modifyTarget(id, idAccountTarget, name);
	}

	@Override
	@Transactional
	public StateResult deleteTarget(String id) {
		return targetAccountDao.deleteTarget(id);
	}

}
