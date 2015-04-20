package com.csc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.csc.entities.Account;
import com.csc.entities.Transaction;
import com.csc.entities.TypeAccount;
import com.csc.service.AccountService;
import com.csc.service.TypeService;



@Controller
@SessionAttributes({"username", "role" })
public class UpdateStateController {
	@Autowired
	AccountService accountService;

/*	@RequestMapping(value = "/updateState", method = RequestMethod.GET )
	public String goViewupdateState(Model model) {
		List<Account> listAccounts = null;
		 listAccounts=accountService.getStateNew();
		model.addAttribute("listAccount", listAccounts);
		return "support/updateState";
	}*/
	@RequestMapping (value = "/updateState", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView updateState(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = new ModelAndView("admin/updateState");
		
		List<Account> account = null;
		account = accountService.getStateNew();
		model.addObject("listAccount", account);
		
		return model;
		
	}
	@RequestMapping(value = "/doupdateState", method = RequestMethod.POST)
	public String addAccount(HttpServletRequest request,
			HttpServletResponse response,Model model) {

		String accountNumber = request.getParameter("accountNumber");
		int state = 2;
		Account existedAccount = accountService.getAccountById(accountNumber);	
		
		if (existedAccount==null) {
			model.addAttribute("message", "This account is not valid");
			

			
		} else {
			accountService.updateStateAccountById(accountNumber, state);
			model.addAttribute("message", "This account have been  modified");
			

		}
		return "forward:/updateState";
	}
	@RequestMapping(value = "/checkAccount", method = RequestMethod.POST)
	public String checkAccount(HttpServletRequest request,
			HttpServletResponse response ,Model model) {{
		String accountNumber1 = request.getParameter("accountNumber1");

		Account account;
		account = accountService.getAccountById(accountNumber1);
		Account existedAccount = accountService.getAccountById(accountNumber1);	
		
		if (existedAccount==null) {
			model.addAttribute("message1", "This account is not valid");
			return "admin/updateState";

			
		} else {
			model.addAttribute("message1", "This account is  valid");
			return "admin/updateState";

		}

	
	}}
/*	@RequestMapping(value = "/doupdateState1", method = RequestMethod.POST)
	public String addAccount1(HttpServletRequest request,
			HttpServletResponse response,Model model) {

		String accountNumber = request.getParameter("accountNumber");
		Account existedAccount = accountService.getAccountById(accountNumber);	
		if (existedAccount==null) {
			model.addAttribute("message", "This account is not valid");
			return "support/updateState";

			
		} else {
			accountService.updateStateAccountById(accountNumber, 2);
			model.addAttribute("message", "This account have been  modified");
			return "support/updateState";

		}
	}*/
	
	@RequestMapping(value = "/doupdateStateDis", method = RequestMethod.POST)
	public String veryfiState (HttpServletRequest request,
			HttpServletResponse response,Model model) {

		String accountNumber = request.getParameter("accountNumber");
		int state = 2;
		Account existedAccount = accountService.getAccountById(accountNumber);	
		
		if (existedAccount==null) {
			model.addAttribute("message", "This account is not valid");
			

			
		} else {
			accountService.updateStateAccountById(accountNumber, state);
			model.addAttribute("message", "This account have been  modified");
			

		}
		return "forward:/updateState";
	}
	
}