package com.csc.dao.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.csc.dao.TransactionDAO;
import com.csc.entities.Transaction;

@Repository
public class TransactionDAOImpl implements TransactionDAO {
	
	@PersistenceContext
	EntityManager em;

	@Override
	public List<Transaction> getTransactionByUserId(String id, int state) {
		// TODO Auto-generated method stub
		List<Transaction> result = null;
		
		TypedQuery<Transaction> query = em.createQuery("SELECT t FROM Transaction t WHERE (t.sendAccount.id = :id "
				+ " OR t.receiveAccount.id = :id) AND t.state.idState = :state", Transaction.class);
		query.setParameter("id", id);
		query.setParameter("state", state);
		result = query.getResultList();
		
		return result;
	}

	@Override
	public List<Transaction> getTransactionByDateRange(String userID,
			Date dateFrom, Date dateTo, int state) {
		// TODO Auto-generated method stub
		List<Transaction> result = null;
		
		TypedQuery<Transaction> query = em.createQuery("SELECT t FROM Transaction t WHERE"
				+ " (t.sendAccount.id = :id OR t.receiveAccount.id = :id) "
				+ "AND t.state.idState = :state "
				+ "AND (t.date >= :dateFrom AND t.date <= :dateTo)", Transaction.class);			
		
		query.setParameter("id", userID);
		query.setParameter("state", state);
		query.setParameter("dateFrom", dateFrom);
		query.setParameter("dateTo", dateTo);
		result = query.getResultList();
		
		return result;
	}

}
