package com.csc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.csc.entities.Account;
import com.csc.service.AccountService;
import com.csc.service.FundService;
import com.csc.ultil.CreateDatabase;

@Controller
public class FundsController {
	
	@Autowired
	FundService fundService;
	
	@Autowired
	AccountService accountService;
	
	@RequestMapping (value = "/viewAddFunds", method = RequestMethod.GET)
	public String goViewAddFund() {
		return "support/addFunds";
	}
	
	@RequestMapping (value = "/getAccountById", method=RequestMethod.POST)
	@ResponseBody
	public Account getAccountById(HttpServletRequest request, HttpServletResponse response) {
		String accountNumber = request.getParameter("accountNumber");
		Account account = accountService.getAccountById(accountNumber);
		
		return account;
	}
	
	@RequestMapping (value = "/addFund", method = RequestMethod.POST)
	@ResponseBody
	public String addFund(HttpServletRequest request, HttpServletResponse response) {
		
		String accountNumber = request.getParameter("accountNumber");
		long amount = Long.parseLong(request.getParameter("amount"));
		
		boolean result = fundService.addFund(accountNumber, amount);
		if (result) {
			return "success";
		} else {
			return "Error";
		}
	}
	
	@RequestMapping (value = "/viewTransferBySupport", method = RequestMethod.GET)
	public String goViewTranferBySupport() {
		return "support/transfer";
	}

}
