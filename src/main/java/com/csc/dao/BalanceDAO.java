package com.csc.dao;

import java.util.Date;
import java.util.List;

import com.csc.entities.BalanceAmount;
import com.csc.entities.TransactionHistory;

public interface BalanceDAO {

	List<BalanceAmount> getBalanceLogByUserId(String accounNumber);

	List<BalanceAmount> getBalanceByDateRange(String userID, Date dateFrom,
			Date dateTo);

}
