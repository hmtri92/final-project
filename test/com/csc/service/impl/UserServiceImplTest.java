package com.csc.service.impl;

import static org.junit.Assert.*;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.csc.dao.UserDAO;
import com.csc.dao.UtilDAO;
import com.csc.entities.User;
import com.csc.ultil.PasswordUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/config/test-context.xml"})
@Transactional
@TransactionConfiguration (defaultRollback = true)
public class UserServiceImplTest {
	@Autowired
	UserDAO userDAO;
	@Autowired
	UtilDAO utilDAO;
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testChangePassword() {
		User sampleUser = (userDAO.getAllUser()).get(0);
		
		if (sampleUser == null) {
			System.err.println("Cannot get the sample user for testing."
					+ " Check the relative function or database.");			
			return;
		}
		
		String beforePass = sampleUser.getPassword();
		
		String rawPass = "11111";
		
		sampleUser.setPassword(PasswordUtils.encodePassword(rawPass));
		
		String afterPass = sampleUser.getPassword();
		
		assertEquals(beforePass, afterPass);
		
		utilDAO.updateEntity(sampleUser);
		
		sampleUser = (userDAO.getAllUser()).get(0);
		
		assertEquals(true, PasswordUtils.matchPassword(rawPass, afterPass));
	}

}
