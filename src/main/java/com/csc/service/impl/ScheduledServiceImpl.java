package com.csc.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csc.dao.AccountDAO;
import com.csc.dao.UtilDAO;
import com.csc.entities.Account;
import com.csc.entities.BalanceAmount;
import com.csc.service.ScheduledService;

@Service("scheduledService")
@Transactional
public class ScheduledServiceImpl implements ScheduledService{
	@Autowired
	AccountDAO accountDAO;
	@Autowired
	UtilDAO utilDAO;
	
	@Transactional
	public boolean updateBalanceHistory(){

		List<Account> listAccount = new ArrayList<Account>();
		listAccount = accountDAO.getStateActive();
		
		if (listAccount.size() == 0) {
			return false;
		}
		
		for (Account account : listAccount) {
			BalanceAmount balance = new BalanceAmount(account.getAvailableAmount(), new Date(), account);
			utilDAO.addEntity(balance);
			
			System.err.println("account " + account.getId());
		}
		return true;
	}
}
