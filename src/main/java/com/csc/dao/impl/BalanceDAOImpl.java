package com.csc.dao.impl;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.csc.dao.BalanceDAO;
import com.csc.entities.BalanceAmount;
import com.csc.entities.Transaction;

@Repository
public class BalanceDAOImpl implements BalanceDAO {
	
	@PersistenceContext
	EntityManager em;

	@Override
	public List<BalanceAmount> getBalanceLogByUserId(String accounNumber) {
		// TODO Auto-generated method stub
		List<BalanceAmount> result = null;
		
		TypedQuery<BalanceAmount> query = em.createQuery("SELECT b FROM BalanceAmount b "
							+ "WHERE b.account.id = :id ", BalanceAmount.class);
		query.setParameter("id", accounNumber);
		
		result = query.getResultList();
		
		return result;
	}

}
