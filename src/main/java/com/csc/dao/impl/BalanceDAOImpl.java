package com.csc.dao.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.csc.dao.BalanceDAO;
import com.csc.entities.Account;
import com.csc.entities.BalanceAmount;

@Repository("balanceDAO")
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
	
	@Override
	public List<BalanceAmount> getBalanceByDateRange(String userID,
			Date dateFrom, Date dateTo) {
		// TODO Auto-generated method stub
		List<BalanceAmount> result = null;
		
		TypedQuery<BalanceAmount> query = em.createQuery("SELECT b FROM BalanceAmount b WHERE"
				+ " b.account.id = :id "
				+ "AND b.period >= :dateFrom AND b.period <= :dateTo", BalanceAmount.class);			
		
		query.setParameter("id", userID);
		query.setParameter("dateFrom", dateFrom);
		query.setParameter("dateTo", dateTo);
		result = query.getResultList();
		
		return result;
	}

	@Override
	public List<BalanceAmount> getAllBalanceHistory() {
		// TODO Auto-generated method stub
		List<BalanceAmount> result = null;
		
		TypedQuery<BalanceAmount> query = em.createQuery("SELECT b FROM BalanceAmount b ", BalanceAmount.class);	
		
		result = query.getResultList();
		
		return result;
	}

	

}
