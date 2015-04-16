package com.csc.dao;

import com.csc.entities.User;

public interface AuthenticationDAO {

	User getUserByLoginID(String loginId);
}
