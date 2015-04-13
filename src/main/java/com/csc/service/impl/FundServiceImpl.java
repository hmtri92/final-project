package com.csc.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csc.dao.FundDAO;
import com.csc.entities.Account;
import com.csc.entities.TargetAccount;
import com.csc.service.FundService;

@Service
public class FundServiceImpl implements FundService {

	@Autowired
	FundDAO fundDao;
	
	@Override
	public boolean addFund(String id, BigDecimal amount) {
//		boolean result = fundDao.addFund(id, amount);
//		
//		if (result) {
//			return fundDao.addFundTransaction(id, amount);
//		}
//		
//		return false;
		
		return fundDao.addFundTransaction(id, amount);
	}

	@Override
	public Account getAccountById(String accountNumber) {
		return fundDao.getAccountById(accountNumber);
	}

	@Override
	public boolean transfer(String sendAccount_ID, String targetAccount_ID,
			BigDecimal amount) {
//		 boolean result = fundDao.transfer(sendAccount_ID, targetAccount_ID, amount);
//		 
//		 if(result) {
//			 return fundDao.transferTransaction(sendAccount_ID, targetAccount_ID, amount);
//		 }
//		 return false;
		
		return fundDao.transferTransaction(sendAccount_ID, targetAccount_ID, amount);
	}

	@Override
	public List<TargetAccount> getTargetAccount(String id) {
		return fundDao.getTargetAccount(id);
	}

	@Override
	public boolean transferTargetID(String sendAccount_ID, String targetAccount_ID,
			BigDecimal amount) {
//		boolean result = fundDao.transferTargetID(sendAccount_ID, targetAccount_ID, amount);
//		if(result) {
//			 return fundDao.transferTransactionTargetID(sendAccount_ID, targetAccount_ID, amount);
//		 }
//		 return false;
		return fundDao.transferTransactionTargetID(sendAccount_ID, targetAccount_ID, amount);
	}

	@Override
	public boolean withdraw(String accountNumber, BigDecimal amount) {
//		boolean result = fundDao.withdraw(accountNumber, amount);
//		if(result) {
//			 return fundDao.withdrawTransaction(accountNumber, amount);
//		 }
//		return false;
//		
		return fundDao.withdrawTransaction(accountNumber, amount);
	}

}
