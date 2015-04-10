package com.csc.dao.impl;

import javax.persistence.EntityManagerFactory;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;

import com.csc.dao.CustomerDAO;
import com.csc.entities.User;

public class CustomerDAOImpl implements CustomerDAO{

	@Override
	public User getCustomerInfo(String customerId) {
		User customer = null;
		
		WebApplicationContext ctx = ContextLoaderListener.getCurrentWebApplicationContext();
		
		return customer;
	}

}
