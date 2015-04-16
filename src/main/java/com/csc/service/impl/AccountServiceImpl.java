package com.csc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csc.dao.AccountDAO;
import com.csc.entities.Account;
import com.csc.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	AccountDAO accountDao;

	@Override
	public Boolean addAccount(Account account, int idRole, int idType) {
		Boolean result = accountDao.addAccount(account, idRole, idType);

		if (result) {
			return true;
		}
		return false;
	}

	@Override
	public Account getAccountById(String id) {
	return	accountDao.getAccountById(id);
		
	}

	@Override
	public Account updateStateAccountById(String id, int state) {
		return accountDao.updateStateAccountById(id, state);
	}

}
