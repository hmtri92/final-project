package com.csc.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import com.csc.dao.UtilDAO;

@Repository
public class UtilDAOImpl implements UtilDAO {
	@PersistenceContext
	EntityManager em;

	@Override
	@Transactional
	public boolean addEntity(Object obj) {
		// TODO Auto-generated method stub
		em.persist(obj); 
		return false;
	}

	@Override
	@Transactional
	public boolean updateEntity(Object obj) {
		// TODO Auto-generated method stub
		em.merge(obj);
		return false;
	}

	@Override
	@Transactional
	public boolean removeEntity(Object obj) {
		// TODO Auto-generated method stub
		em.remove(obj);
		return false;
	}

}
