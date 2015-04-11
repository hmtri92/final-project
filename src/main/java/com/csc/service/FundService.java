package com.csc.service;

import java.math.BigDecimal;

import com.csc.entities.Account;


public interface FundService {
	boolean addFund(String id, BigDecimal amount);
	Account getAccountById(String accountNumber);
}

