package com.csc.dao;

import com.csc.entities.Account;

public interface AccountDAO {
	boolean addAccount(Account account, int idRole, int idType);

	public Account getAccountById(String id);

	public Account updateStateAccountById(String id, int state);

}
