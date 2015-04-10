package com.csc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csc.dao.FundDAO;
import com.csc.service.FundService;

@Service
public class FundServiceImpl implements FundService {

	@Autowired
	FundDAO fundDao;
	
	@Override
	public boolean addFund(String id, long amount) {
		return fundDao.addFund(id, amount);
	}

}
