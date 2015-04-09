package com.csc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.csc.dao.AccountDAO;
import com.csc.entities.Account;
import com.csc.service.AccountService;

public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountDAO accountDao;
	
	@Override
	public Account getAccountById(String accountNumber) {
		
		return accountDao.getAccountById(accountNumber);
		
	}

}
