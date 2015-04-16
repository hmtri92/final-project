package com.csc.dao.impl;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.csc.dao.AccountDAO;
import com.csc.entities.Account;
import com.csc.entities.Role;
import com.csc.entities.State;
import com.csc.entities.Transaction;
import com.csc.entities.TypeAccount;


@Repository
public class AccountDAOImpl implements AccountDAO {



	@PersistenceContext
	EntityManager em;
	
	@Override
	@Transactional
	public boolean addAccount(Account account, int idRole, int idType) {
		

		Role role = em.find(Role.class, idRole);
		TypeAccount type = em.find(TypeAccount.class, idType);
		State state = em.find(State.class, State.NEW);

		account.setRole(role);
		account.setTypeAccount(type);
		account.setState(state);
		em.persist(account);
		
		return true;
	}
	@Override
	public Account getAccountById(String id) {
		Account account = em.find(Account.class, id);
		return account ;		
}
	@Override
	@Transactional
	public Account updateStateAccountById(String id,int idstate) {
			Account account = em.find(Account.class, id);
			State state = em.find(State.class, idstate);
			account.setState(state);
			return account;
		
		
	}
}