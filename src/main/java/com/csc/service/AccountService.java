package com.csc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csc.dao.AccountDAO;



@Service
public class AccountService {
	@Autowired
	AccountDAO AccountDao;

	public boolean addNewAccount(String accountNumber, int typeAccount,
			String idCardNumber, String firstName, String lastName,
			String midName, long phoneNum1, long phoneNum2, String address1,
			String address2, String email1, String email2,
			Long availableAmount, int state, int role) {
		return AccountDao.addAccount(accountNumber, typeAccount, idCardNumber,
				firstName, lastName, midName, phoneNum1, phoneNum2, address1,
				address2, email1, email2, availableAmount, state, role);
	}


}
