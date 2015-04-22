package com.csc.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.csc.dao.ITargetAccountDAO;
import com.csc.entities.TargetAccount;

@Repository
public class TargetAccountDAOImpl implements ITargetAccountDAO {

	@PersistenceContext
	EntityManager em;
	
	@Override
	public List<TargetAccount> getListTargetByAccountOwnerId(String id) {
		String sql = "SELECT t FROM TargetAccount t WHERE t.accountOwner.id = :id";
		TypedQuery<TargetAccount> query = em.createQuery(sql, TargetAccount.class);
		query.setParameter("id", id);
		
		return query.getResultList();
	}

}
