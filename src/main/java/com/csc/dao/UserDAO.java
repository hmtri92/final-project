package com.csc.dao;

import com.csc.entities.User;

public interface UserDAO {
	
	public User getUser(String customerId);

	public boolean changeInfo(User user);

	
	

}
