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
		return em.find(Account.class, id);
}
	@Override
	@Transactional
	public Account updateStateAccountById(String id,int idstate) {
			Account account = em.find(Account.class, id);
			State state = em.find(State.class, idstate);
			account.setState(state);
			em.persist(account);
			
			return account;
		
		
	}
	@Override
	@Transactional
	public Account updateAccount(String id, int idstate, int idRole,String firtname,String lastname,String midname,
			int idType,String email1,String email2,String address1,String address2,String phoneNumber1,String phoneNumber2,String idcardNumber) {
		
			Account account = em.find(Account.class, id);
			State state = em.find(State.class, idstate);
			Role role = em.find(Role.class, idRole);
			TypeAccount type = em.find(TypeAccount.class, idType);
			account.setState(state);
			account.setRole(role);
			account.setTypeAccount(type);
			account.setAddress1(address1);
			account.setAddress2(address2);
			account.setEmail1(email1);
			account.setEmail2(email2);
			account.setFirstName(firtname);
			account.setLastName(lastname);
			account.setMidName(midname);
			account.setPhoneNum1(phoneNumber1);
			account.setPhoneNum2(phoneNumber2);
			account.setIdCardNumber(idcardNumber);
			em.persist(account);
			return account;
	}

}

