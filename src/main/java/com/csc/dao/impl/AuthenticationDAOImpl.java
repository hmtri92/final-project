package com.csc.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.csc.dao.AuthenticationDAO;
import com.csc.entities.User;

@Repository
public class AuthenticationDAOImpl implements AuthenticationDAO {

	@PersistenceContext
	EntityManager em;
	
	@Override
	@Transactional
	public User getUserByLoginID(String loginId) {
		String sql = "SELECT u FROM User u WHERE u.loginID = :loginId";
		TypedQuery<User> query = em.createQuery(sql, User.class);
		query.setParameter("loginId", loginId);
		return query.getSingleResult();
	}

	
}
