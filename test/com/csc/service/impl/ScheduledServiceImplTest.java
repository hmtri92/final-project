package com.csc.service.impl;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.csc.dao.AccountDAO;
import com.csc.dao.BalanceDAO;
import com.csc.entities.Account;
import com.csc.entities.BalanceAmount;
import com.csc.service.ScheduledService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/config/test-context.xml"})
@Transactional
@TransactionConfiguration (defaultRollback = true)
public class ScheduledServiceImplTest {
	@Autowired 
	AccountDAO accountDAO;
	@Autowired
	BalanceDAO balanceDAO;
	@Autowired
	ScheduledService scheduledService;
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testUpdateBalanceHistory() {
		System.err.println("asdasdasd");
		
		List<Account> listActiveAccount = accountDAO.getStateActive();
		
		if (!(listActiveAccount.size() > 0)) {
			System.err.println("Cannot get the sample account list for testing."
					+ " Check the relative function or database.");			
			return;
		}
		
		List<BalanceAmount> listBalance = balanceDAO.getAllBalanceHistory(); 
		
		int beforeBalanceCount = listBalance.size();
		
		scheduledService.updateBalanceHistory();
		
		listBalance = balanceDAO.getAllBalanceHistory();
		
		int afterBalanceCount = listBalance.size();
				
		assertEquals(beforeBalanceCount + listActiveAccount.size(), afterBalanceCount);
		
		for (Account account : listActiveAccount) {
			List<BalanceAmount> tmpList = balanceDAO.getBalanceLogByUserId(account.getId());
			BalanceAmount savedAmount = tmpList.get(tmpList.size() - 1);
			assertEquals(savedAmount.getBalance(), account.getAvailableAmount());
		}
	}

}
