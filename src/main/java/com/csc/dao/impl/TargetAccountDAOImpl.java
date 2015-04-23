package com.csc.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.csc.dao.ITargetAccountDAO;
import com.csc.entities.StateResult;
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

	@Override
	public StateResult addTargetAccount(String idAccountOwner,
			String idAccountTarget, String name) {
		StateResult result = new StateResult();
		try {
			String sql = "INSERT INTO TargetAccount(accountOwner, accountTarget, name) " +
				"VALUE(?,?,?) ";
			Query query = em.createNativeQuery(sql);
			query.setParameter(1, idAccountOwner);
			query.setParameter(2, idAccountTarget);
			query.setParameter(3, name);
			query.executeUpdate();
			
			result.setState(true);
			result.setMessage("Success");
		} catch (Exception e) {
			result.setState(false);
			result.setMessage("Can't not create TargetAccount");
		}
		
		return result;
	}

}
