package com.csc.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.csc.dao.AccountDAO;
import com.csc.entities.Account;

public class AccountDaoImpl implements AccountDAO {

	@PersistenceContext
	EntityManager em;
	
	@Override
	public Account getAccountById(String accountNumber) {
		Account account = em.find(Account.class, accountNumber);
		return account;
	}

}
