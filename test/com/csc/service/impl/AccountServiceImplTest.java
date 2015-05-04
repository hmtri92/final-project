package com.csc.service.impl;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.csc.entities.Account;
import com.csc.entities.User;
import com.csc.ultil.PasswordUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/config/test-context.xml"})
@Transactional
@TransactionConfiguration (defaultRollback = true)
public class AccountServiceImplTest {

	@Autowired
	AccountServiceImpl accountService;
	
	private static final Logger logger = Logger.getLogger(AccountServiceImplTest.class);
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}



	@Test
	public void testGetAccountById() {
		Account minhtri = accountService.getAccountById("");
		assertNull(minhtri);
		logger.info("Account is null");
		
		minhtri = accountService.getAccountById("123456789001");
		assertEquals("123456789001", minhtri.getId());
		logger.info("Account: " + minhtri.getId() + " " + minhtri.getLastName());
	}

	
	@Test
	public void testUpdateStateAccountById() {
		Account user = accountService.getAccountById("012345678902");
		if(user==null)
		{
			assertNull(user);
		}
		else 
		{
		int state=2;
		accountService.updateStateAccountById("012345678902", state);
		assertEquals(2, user.getState().getIdState());
		assertNotEquals(3, user.getState().getIdState());
		int state1=3;
		accountService.updateStateAccountById("012345678902", state1);
		assertEquals(3, user.getState().getIdState());
		assertNotEquals(6, user.getState().getIdState());
		int state2=4;
		accountService.updateStateAccountById("012345678902", state2);
		assertEquals(4, user.getState().getIdState());
		assertNotEquals(6, user.getState().getIdState());
		int state3=5;
		accountService.updateStateAccountById("012345678902", state3);
		assertEquals(5, user.getState().getIdState());
		assertNotEquals(6, user.getState().getIdState());
		}
		
		
	}

	
	@Test
	public void testUpdateAccount() {
		Account user = accountService.getAccountById("012345678902");
		if(user==null)
		{
			assertNull(user);
		}
		else{
		int roleTest = 2;
		int typeAccountTest = 2;
		int state1=2;
		String idTest=("012345678902");
		String IdCardTest=("222222222");
		String firstNameTest=("Anha");
		String lastNameTest=("Voa ");
		String midNameTest=("betandaaa");
		String adddress1Test=("Truong Chinha");
		String adddress2Test=("tan Binh tapa");
		String email1Test=("betanda1@yahoo.coma");
		String email2Test=("betan@gmai.coma");
		String phone1Test=("123456222");
		String phone2Test=("1234567222");
		accountService.updateAccount(idTest, state1, roleTest, firstNameTest, lastNameTest, midNameTest, typeAccountTest, email1Test, email2Test, adddress1Test, adddress2Test, phone1Test, phone2Test, IdCardTest);
		assertEquals(IdCardTest, user.getIdCardNumber());
		assertNotEquals("4444444444444", user.getIdCardNumber());
		assertEquals(firstNameTest, user.getFirstName());
		assertEquals(lastNameTest, user.getLastName());
		assertEquals(midNameTest, user.getMidName());
		assertEquals(adddress1Test, user.getAddress1());
		assertEquals(adddress2Test, user.getAddress2());
		assertEquals(email1Test, user.getEmail1());
		assertEquals(email2Test, user.getEmail2());
		assertEquals(phone1Test, user.getPhoneNum1());
		assertEquals(phone2Test, user.getPhoneNum2());
		}
	}

	
	@Test
	public void testGetStateNew() {
		List<Account> listStateNew =accountService.getStateNew();
		if(listStateNew==null)
		{
			assertNull(listStateNew);
		}
		if(listStateNew.size()>=1 &&listStateNew.size()<=1)
		{
		assertEquals("NEW", listStateNew.get(0).getState().getName());
		}
		if( listStateNew.size()>=2 )
		{
		assertEquals("NEW", listStateNew.get(1).getState().getName());
		assertEquals("NEW", listStateNew.get(2).getState().getName());
		
		
		}
		
		
	}


	@Test
	public void testGetStateDis() {
		List<Account> listStateDis =accountService.getStateDis();
		if(listStateDis==null)
		{
			assertNull(listStateDis);
		}
		if(listStateDis.size()>=1 &&listStateDis.size()<=1)
		{
		assertEquals("DISABLE", listStateDis.get(0).getState().getName());
		}
		if( listStateDis.size()>=2 )
		{
		assertEquals("DISABLE", listStateDis.get(1).getState().getName());
		assertEquals("DISABLE", listStateDis.get(2).getState().getName());
		
		
		}
	}



	@Ignore
	@Test
	public void testGetRecomendedKey() {
		fail("Not yet implemented");
	}


	@Test
	public void testAddUser() {
		User user = new User();
		String password = "123456";
		try {
			password = PasswordUtils.generateRandomString(6);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String passwordEncode = PasswordUtils.encodePassword(password);
		int role = 1;
		int typeAccount = 1;
		user.setId("123456789012");
		BigDecimal amount = BigDecimal.valueOf(0);
		user.setAvailableAmount(amount);
		user.setIdCardNumber("123456789");
		user.setFirstName("Anh");
		user.setLastName("Vo ");
		user.setMidName("betanda");
		user.setAddress1("Truong Chinh");
		user.setAddress2("tan Binh tap");
		user.setEmail1("betanda1@yahoo.com");
		user.setEmail2("betan@gmai.com");
		user.setPhoneNum1("123456789");
		user.setPhoneNum2("123456789");
		user.setPassword(passwordEncode);
		user.setLoginID("betanda3");
		accountService.addUser(user, role, typeAccount);
		Account Test = accountService.getAccountById("123456789012");
		assertEquals("123456789012", Test.getId());
		assertTrue(accountService.addUser(user, role, typeAccount));
	}

	
	
	@Test
	public void testCheckLoginid() {
		String LoginIDTrue ="admin";
		String LoginIdFalse ="admin1";
		assertTrue(accountService.checkLoginid(LoginIDTrue));
		assertFalse(accountService.checkLoginid(LoginIdFalse));
		
		
	}

	
	@Test
	public void testGetStateActive() {
		List<Account> listStateActive =accountService.getStateActive();
		if(listStateActive==null)
		{
			assertNull(listStateActive);
		}
		if(listStateActive.size()>=1 &&listStateActive.size()<=1)
		{
		assertEquals("ACTIVE", listStateActive.get(0).getState().getName());
		}
		if( listStateActive.size()>=2 )
		{
		assertEquals("ACTIVE", listStateActive.get(1).getState().getName());
		assertEquals("ACTIVE", listStateActive.get(2).getState().getName());
		
		
		}
	}

	@Ignore
	@Test
	public void testSearchAccount() {
		fail("Not yet implemented");
	}


	@Test
	public void testGetStateRemvo() {
		List<Account> listStateRemove =accountService.getStateRemvo();
		if(listStateRemove==null)
		{
			assertNull(listStateRemove);
		}
		if(listStateRemove.size()>1)
		{
		assertEquals("REMOVEABLE", listStateRemove.get(0).getState().getName());
		}
		if(listStateRemove.size()>4)
		{
		assertEquals("REMOVEABLE", listStateRemove.get(1).getState().getName());
		assertEquals("REMOVEABLE", listStateRemove.get(2).getState().getName());
		assertEquals("REMOVEABLE", listStateRemove.get(3).getState().getName());
		assertEquals("REMOVEABLE", listStateRemove.get(4).getState().getName());

		}
		
		}

}
