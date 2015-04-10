package com.csc.dao;

import com.csc.entities.Account;

public interface FundDAO {
	boolean addFund(String id, long amount);
	void saveAddFundTransaction(Account account, long amount);
}
