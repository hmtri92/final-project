package com.csc.service;

import com.csc.beans.UserBean;

public interface CustomerService {
	
	public abstract UserBean getCustomerInfo(String customerId);

}
