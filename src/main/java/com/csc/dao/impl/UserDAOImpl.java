package com.csc.dao.impl;



import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.csc.dao.UserDAO;
import com.csc.entities.User;

@Repository
public class UserDAOImpl implements UserDAO{
	
	@PersistenceContext
	EntityManager em;

	@Override
	public User getUser(String UserId) {
		User user = null;
		
		user = em.find(User.class, UserId);
		
		return user;
	}

	@Override
	@Transactional
	public boolean changeInfo(User user) {
		// TODO Auto-generated method stub
		try {
			em.merge(user);
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
		return true;
	}

	/*
	 * minh tri
	 * 
	 */
	@Override
	public User getUserByID(String id) {
		return em.find(User.class, id);
	}

	
	
}
