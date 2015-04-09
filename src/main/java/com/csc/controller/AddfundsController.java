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

@Controller
public class AddfundsController {
	
	@Autowired
	FundService fundService;
	
	@Autowired
	AccountService accountService;
	
	@RequestMapping (value = "viewAddFunds", method = RequestMethod.GET)
	public String goViewAddFuncd() {
		return "support/addFunds";
	}
	
	@RequestMapping (value = "/getAccountById", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView getAccountById(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = new ModelAndView();
		String accountNumber = request.getParameter("accountNumber");
		
		Account account = accountService.getAccountById(accountNumber);
		model.addObject("account", account);
		
		return model;
	}

}
