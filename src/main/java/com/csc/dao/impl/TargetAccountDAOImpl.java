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

	@Override
	public StateResult modifyTarget(String id, String idAccountTarget,
			String name) {
		StateResult result = new StateResult();
		try {
			long idTarget = Long.parseLong(id);
			String sql = "UPDATE TargetAccount t SET t.accountTarget = :accountTarget, t.name = :name"
					+ " WHERE t.idtagrget = :idtagrget";
			Query query = em.createNativeQuery(sql);
			query.setParameter("accountTarget", idAccountTarget);
			query.setParameter("name", name);
			query.setParameter("idtagrget", idTarget);
			query.executeUpdate();
			
			result.setState(true);
			result.setMessage("Success");
		} catch (Exception e) {
			result.setState(false);
			result.setMessage("Fail");
		}
		return result;
	}

	@Override
	public StateResult deleteTarget(String id) {
		StateResult result = new StateResult();
		try {
			long idTarget = Long.parseLong(id);
			String sql = "DELETE FROM TargetAccount t WHERE t.idtagrget = :idtagrget";
			Query query = em.createQuery(sql);
			query.setParameter("idtagrget", idTarget);
			query.executeUpdate();
			
			result.setState(true);
			result.setMessage("Success");
		} catch (Exception e) {
			result.setState(false);
			result.setMessage("Fail");
		}
		return result;
	}

	@Override
	public TargetAccount getTargetAccountByOwnerAndTarget(String idOwner,
			String idTarget) {
		String sql = "SELECT t FROM TargetAccount t "
				+ "WHERE t.accountOwner.id = :accountOwner AND t.accountTarget.id = :accountTarget";
		TypedQuery<TargetAccount> query = em.createQuery(sql, TargetAccount.class);
		query.setParameter("accountOwner", idOwner);
		query.setParameter("accountTarget", idTarget);
		
		TargetAccount targetAccount = query.getSingleResult();
		return targetAccount;
	}
	
	

}
