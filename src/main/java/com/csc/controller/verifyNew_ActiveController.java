package com.csc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.csc.entities.Account;
import com.csc.entities.StateResult;
import com.csc.entities.TransactionHistory;
import com.csc.service.AccountService;
import com.csc.service.FundService;

@Controller
@SessionAttributes({"username", "role" })
public class verifyNew_ActiveController {

	@Autowired
	AccountService accountService;
	
	@RequestMapping (value = "/admin/viewVerifyStateNew", method = RequestMethod.GET)
	public ModelAndView verifyTransaction(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = new ModelAndView("admin/verifyNew_Active");
		
		List<Account> listStateNew = null;
		listStateNew = accountService.getStateNew();
		model.addObject("listStateNew", listStateNew);
		
		return model;
	}
	
	@RequestMapping (value = "/admin/doVerifySateNew", method = RequestMethod.POST)
	@ResponseBody
	public Account doVerifyStateNew(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		int state=2;
		return accountService.updateStateAccountById(id, state);
	}
}
