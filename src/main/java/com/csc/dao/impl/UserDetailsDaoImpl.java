package com.csc.dao.impl;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.csc.dao.UserDAO;
import com.csc.dao.UserDetailsDAO;
import com.csc.entities.User;

@Repository
public class UserDetailsDaoImpl extends JdbcDaoSupport implements UserDetailsDAO {
	
	private static final String SQL_USERS_UPDATE_LOCKED = "UPDATE USERS SET accountNonLocked = ? WHERE username = ?";
	private static final String SQL_USERS_COUNT = "SELECT count(*) FROM USERS WHERE username = ?";
 
	private static final String SQL_USER_ATTEMPTS_GET = "SELECT * FROM USER_ATTEMPTS WHERE username = ?";
	private static final String SQL_USER_ATTEMPTS_INSERT = "INSERT INTO USER_ATTEMPTS (USERNAME, ATTEMPTS, LASTMODIFIED) VALUES(?,?,?)";
	private static final String SQL_USER_ATTEMPTS_UPDATE_ATTEMPTS = "UPDATE USER_ATTEMPTS SET attempts = attempts + 1, lastmodified = ? WHERE username = ?";
	private static final String SQL_USER_ATTEMPTS_RESET_ATTEMPTS = "UPDATE USER_ATTEMPTS SET attempts = 0, lastmodified = null WHERE username = ?";

	private static final int MAX_ATTEMPTS = 3;
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	UserDAO userDao;
	
	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
	}
	
	@Override
	public void updateFailAttempts(String username) {
//		User user = 

	}

	@Override
	public void resetFailAttempts(String username) {
		// TODO Auto-generated method stub

	}

	@Override
	public User getUserAttempts(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
