package com.csc.dao;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import com.csc.entities.Transaction;

public interface TransactionDAO {
	public List<Transaction> getTransactionByUserId(String id, int state);

	public List<Transaction> getTransactionByDateRange(String userID,
			Date dateFrom, Date dateTo, int state);
}

