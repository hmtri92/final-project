package com.csc.service.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csc.dao.FundDAO;
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
	public boolean transfer(String sendAccount_ID, String targetAccount_ID,
			BigDecimal amount) {
		return transactionDao.transferTransaction(sendAccount_ID, targetAccount_ID, amount);
	}

	@Override
	@Transactional
	public List<TargetAccount> getTargetAccount(String id) {
		return fundDao.getTargetAccount(id);
	}

	@Override
	@Transactional
	public boolean transferTargetID(String sendAccount_ID, String targetAccount_ID,
			BigDecimal amount) {
		return transactionDao.transferTransactionTargetID(sendAccount_ID, targetAccount_ID, amount);
	}

	@Override
	@Transactional
	public boolean withdraw(String accountNumber, BigDecimal amount) {
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
		
		if (result.getsState()) {
			transactionDao.changeStateTransaction(transaction.getIdTransaction());
		}
		
		return result;
	}

}
