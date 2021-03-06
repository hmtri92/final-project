package com.csc.dao.impl;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.csc.dao.UserDAO;
import com.csc.entities.User;

/**
 * Handles actions on user entities
 * @author Phuc Doan *
 */
@Repository
public class UserDAOImpl implements UserDAO{
	@PersistenceContext
	EntityManager em;
	
	/**
	 * Change user information
	 * @author Phuc Doan
	 */
	@Override
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

	/**
	 * Get user entity by login Id
	 * @author Phuc Doan
	 */
	@Override
	public User getUserByLoginID(String loginId) {
		String sql = "SELECT u FROM User u WHERE u.loginID = :loginId";
		TypedQuery<User> query = em.createQuery(sql, User.class);
		query.setParameter("loginId", loginId);
		return query.getSingleResult();
	}

	/**
	 * Get all user enity
	 * @author Phuc Doan
	 */
	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		String sql = "SELECT u FROM User u";
		TypedQuery<User> query = em.createQuery(sql, User.class);
		return query.getResultList();
	}
}
