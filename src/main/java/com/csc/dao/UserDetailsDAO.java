package com.csc.dao;

import com.csc.entities.User;

public interface UserDetailsDAO {
	
	void updateFailAttempts(String username);
	void resetFailAttempts(String username);
	User getUserAttempts(String username);
}
