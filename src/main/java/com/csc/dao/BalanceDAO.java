package com.csc.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.csc.entities.Account;
import com.csc.entities.BalanceAmount;

public interface BalanceDAO {

	List<BalanceAmount> getBalanceLogByUserId(String accounNumber);

	List<BalanceAmount> getBalanceByDateRange(String userID, Date dateFrom,
			Date dateTo);
	
	List<BalanceAmount> getAllBalanceHistory();

}
