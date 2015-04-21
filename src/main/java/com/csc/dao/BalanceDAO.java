package com.csc.dao;

import java.util.List;

import com.csc.entities.BalanceAmount;

public interface BalanceDAO {

	List<BalanceAmount> getBalanceLogByUserId(String accounNumber);

}
