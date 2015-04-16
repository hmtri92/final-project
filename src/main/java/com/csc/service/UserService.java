package com.csc.service;

import com.csc.entities.User;

public interface UserService {
	
	public User getUserInfo(String customerId);

	public String changePassword(String id, String oldPassword,
			String newPassword);

	public String editUserInfo(String id, String firstName, String midName,
			String lastName, String address2, String phone2);

}
