package com.csc.service.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csc.dao.FundDAO;
import com.csc.entities.Account;
import com.csc.service.FundService;

@Service
public class FundServiceImpl implements FundService {

	@Autowired
	FundDAO fundDao;
	
	@Override
	public boolean addFund(String id, BigDecimal amount) {
		boolean result = fundDao.addFund(id, amount);
		
		if (result) {
			return fundDao.addFundTransaction(id, amount);
		}
		
		return false;
	}

	@Override
	public Account getAccountById(String accountNumber) {
		return fundDao.getAccountById(accountNumber);
	}

}
