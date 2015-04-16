package com.csc.service;

import com.csc.entities.Account;

public interface AccountService {
	public abstract Boolean addAccount(Account account, int idRole, int idType);

	Account getAccountById(String id);

	public Account updateStateAccountById(String id, int state);

}
