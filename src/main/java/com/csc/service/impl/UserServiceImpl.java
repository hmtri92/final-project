package com.csc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csc.beans.UserBean;
import com.csc.dao.UserDAO;
import com.csc.entities.User;
import com.csc.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDAO userDAO;

	@Override
	public User getUserInfo(String userId) {
		User user = null;
		
		user = userDAO.getUser(userId);
		
		return user;
	}

	@Override	
	public String changePassword(String id, String oldPassword,
			String newPassword) {
		// TODO Auto-generated method stub
		User user = userDAO.getUser(id);
		
		if (!user.getPassword().equals(oldPassword)) {
			return "FAIL: The current password is incorrect!";
		}
		
		if (newPassword.length() < 8 || newPassword.indexOf(' ') != -1){
			return "FAIL: The new password is incorrect!";
		}
		
		user.setPassword(newPassword);
		
		boolean result = userDAO.changeInfo(user);
		
		if (result) {
			return "SUCCESS: The password is changed successfully!";
		}
		return "FAIL: Error while processing request...";
	}

	@Override
	public String editUserInfo(String id, String firstName, String midName,
			String lastName, String address2, String phone2) {
		
		
		if (firstName == null || firstName == "") {
			return "FAIL: The first name is incorrect!";
		}
		if (lastName == null || lastName == "") {
			return "FAIL: The last name is incorrect!";
		}
		
		User user = userDAO.getUser(id);
		
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setMidName(midName);
		user.setAddress2(address2);
		user.setPhoneNum2(phone2);
		
		boolean result = userDAO.changeInfo(user);
		
		if (result) {
			return "SUCCESS: The information is updated successfully!";
		}
		return "FAIL: Error while processing request...";
	}

}
