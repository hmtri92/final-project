package com.csc.controller;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.csc.entities.Account;
import com.csc.service.FundService;

@Controller
public class FundsController {
	
	@Autowired
	FundService fundService;
	
	@RequestMapping (value = "/viewAddFunds", method = RequestMethod.GET)
	public String goViewAddFund() {
		return "support/addFunds";
	}
	
	@RequestMapping (value = "/getAccountById", method=RequestMethod.POST)
	@ResponseBody
	public Account getAccountById(HttpServletRequest request, HttpServletResponse response) {
		String accountNumber = request.getParameter("accountNumber");
		Account account = fundService.getAccountById(accountNumber);
		
		System.out.println(account.getFirstName() + " "
				+ account.getMidName() + " "
				+ account.getLastName() + " "
				+ account.getAddress1() + " "
				+ account.getAddress2() + " "
				+ account.getPhoneNum1() + " "
				+ account.getPhoneNum2());
		
		return account;
	}
	
	@RequestMapping (value = "/addFund", method = RequestMethod.POST)
	@ResponseBody
	public String addFund(HttpServletRequest request, HttpServletResponse response) {
		
		String accountNumber = request.getParameter("accountNumber");
		BigDecimal amount = BigDecimal.valueOf(Long.parseLong(request.getParameter("amount")));
		
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
	
	
	@RequestMapping (value = "/transferBySupport", method=RequestMethod.POST)
	@ResponseBody
	public String transferBySupport(HttpServletRequest request, HttpServletResponse response) {
		String sendAccount = request.getParameter("sendAccount");
		String targetAccount = request.getParameter("targetAccount");
		BigDecimal amount = BigDecimal.valueOf(Long.parseLong(request.getParameter("amount")));
		
		boolean result = fundService.transferBySupport(sendAccount, targetAccount, amount);
		
		if (result) {
			return "success";
		}
		return "Error";
	}

}
