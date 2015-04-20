package com.csc.dao;

import java.util.List;

import com.csc.entities.Account;
import com.csc.entities.Transaction;

public interface AccountDAO {
	boolean addAccount(Account account, int idRole, int idType);

	public Account getAccountById(String id);

	public Account updateStateAccountById(String id, int state);

	public Account updateAccount(String id, int idstate, int idRole, String firtname,
			String lastname, String midname, int idType, String email1,
			String email2, String address1, String address2,
			String phoneNumber1, String phoneNumber2, String idcardNumber);

		public List<Account> getStateNew();
		public List<Account> getStateDis();
}
