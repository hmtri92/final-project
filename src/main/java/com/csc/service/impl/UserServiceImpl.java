package com.csc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csc.dao.AuthenticationDAO;
import com.csc.dao.BalanceDAO;
import com.csc.dao.TransactionDAO;
import com.csc.dao.UserDAO;
import com.csc.entities.BalanceAmount;
import com.csc.entities.Transaction;
import com.csc.entities.User;
import com.csc.service.UserService;
import com.csc.ultil.PasswordUtils;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDAO userDAO;	
	@Autowired
	AuthenticationDAO authenticationDao;
	@Autowired
	TransactionDAO transactionDAO;
	@Autowired
	BalanceDAO balanceDAO;

	@Override
	public User getUserInfo(String userId) {
		User user = null;
		
		user = userDAO.getUserByID(userId);
		
		return user;
	}

	@Override	
	public String changePassword(String id, String oldPassword,
			String newPassword) {
		// TODO Auto-generated method stub
		User user = userDAO.getUserByID(id);
		
		
		
		
		if (!PasswordUtils.matchPassword(oldPassword, user.getPassword())) {		
			return "FAIL: The current password is incorrect!";
		}
		
		if (newPassword.length() < 8 || newPassword.indexOf(' ') != -1){
			return "FAIL: The new password is incorrect!";
		}
		
		user.setPassword(PasswordUtils.encodePassword(newPassword));
		
		boolean result = userDAO.changeInfo(user);
		
		if (result) {
			return "SUCCESS: The password is changed successfully!";
		}
		return "FAIL: Error while processing request...";
	}

	@Override
	public String editUserInfo(String id, String firstName, String midName,
			String lastName, String address2, String phone2, String email2) {
		
		
		if (firstName == null || firstName == "") {
			return "FAIL: The first name is incorrect!";
		}
		if (lastName == null || lastName == "") {
			return "FAIL: The last name is incorrect!";
		}
		
		User user = userDAO.getUserByID(id);
		
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setMidName(midName);
		user.setAddress2(address2);
		user.setPhoneNum2(phone2);
		user.setEmail2(email2);
		
		boolean result = userDAO.changeInfo(user);
		
		if (result) {
			return "SUCCESS: The information is updated successfully!";
		}
		return "FAIL: Error while processing request...";
	}

	/*
	 * Minh Tri
	 * @see com.csc.service.UserService#getUserByLoginId(java.lang.String)
	 */
	@Override
	public User getUserByLoginId(String loginId) {
		return authenticationDao.getUserByLoginID(loginId);
	}

	@Override
	public User getUserByID(String id) {
		return userDAO.getUserByID(id);
	}

	@Override
	public List<Transaction> getTransactionByUserId(String id, int state) {
		// TODO Auto-generated method stub
		List<Transaction> result = null;
		
		result = transactionDAO.getTransactionByUserId(id, state);
		
		return result;
	}

	@Override
	public List<BalanceAmount> getBalanceLogByUserId(String accountNumber) {
		// TODO Auto-generated method stub
		List<BalanceAmount> result = null;
		
		result = balanceDAO.getBalanceLogByUserId(accountNumber);
		
		return result;
	}

}
