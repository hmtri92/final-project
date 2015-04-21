package com.csc.dao;

import java.util.List;

import com.csc.entities.Transaction;

public interface TransactionDAO {
	public List<Transaction> getTransactionByUserId(String id, int state);
}

