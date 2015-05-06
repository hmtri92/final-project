package com.csc.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import com.csc.dao.UtilDAO;

@Repository("utilDAO")
public class UtilDAOImpl implements UtilDAO {
	@PersistenceContext
	public EntityManager em;

	@Override
	public boolean addEntity(Object obj) {
		// TODO Auto-generated method stub
		try {
			em.persist(obj); 
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
		return true;
	}

	@Override
	public boolean updateEntity(Object obj) {
		// TODO Auto-generated method stub
		try {
			em.merge(obj);
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
		return true;		
	}

	@Override
	public boolean removeEntity(Object obj) {
		// TODO Auto-generated method stub		
		try {
			em.remove(obj);
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
		return true;
	}

}
