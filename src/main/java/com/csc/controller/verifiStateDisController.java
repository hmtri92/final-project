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
import com.csc.service.AccountService;


@Controller
@SessionAttributes({"username", "role" })
public class verifiStateDisController  {

	@Autowired
	AccountService accountService;
	
	@RequestMapping (value = "/admin/viewVerifyStateDis-Removable", method = RequestMethod.GET)
	public ModelAndView verifyTransaction(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = new ModelAndView("admin/verifyStateDis");
		
		List<Account> listStateNew = null;
		listStateNew = accountService.getStateDis();
		model.addObject("listStateNew", listStateNew);
		
		return model;
	}
	
	@RequestMapping (value = "/admin/doVerifyStateDis", method = RequestMethod.POST)
	@ResponseBody
	public Account doVerifyTransaction(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		int state = 4;
		return accountService.updateStateAccountById(id, state);
	}
}
