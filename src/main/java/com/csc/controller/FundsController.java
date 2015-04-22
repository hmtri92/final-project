package com.csc.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.csc.entities.Account;
import com.csc.entities.TargetAccount;
import com.csc.entities.User;
import com.csc.service.AccountService;
import com.csc.service.FundService;
import com.csc.service.UserService;

@Controller
@SessionAttributes({"username", "role", "id" })
public class FundsController {
	
	@Autowired
	FundService fundService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	AccountService accountService;
	
	@RequestMapping (value = "/support/viewAddFunds", method = RequestMethod.GET)
	public String goViewAddFund() {
		return "support/addFunds";
	}
	
	@RequestMapping (value = "/support/getAccountById", method={RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public Account getAccountById(HttpServletRequest request, HttpServletResponse response) {
		String accountNumber = request.getParameter("accountNumber");
		Account account = fundService.getAccountById(accountNumber);
		
		return account;
	}
	
	@RequestMapping (value = "/support/addFund", method = RequestMethod.POST)
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
	
	@RequestMapping (value = "/support/viewTransferBySupport", method = RequestMethod.GET)
	public String goViewTranferBySupport() {
		return "support/transfer";
	}
	
	
	@RequestMapping (value = "/support/transferBySupport", method=RequestMethod.POST)
	@ResponseBody
	public String transferBySupport(HttpServletRequest request, HttpServletResponse response) {
		String sendAccount = request.getParameter("sendAccount");
		String targetAccount = request.getParameter("targetAccount");
		BigDecimal amount = BigDecimal.valueOf(Long.parseLong(request.getParameter("amount")));
		
		boolean result = fundService.transfer(sendAccount, targetAccount, amount);
		
		if (result) {
			return "success";
		}
		return "Error";
	}
	
	@RequestMapping (value = "/user/viewTransferByUser", method=RequestMethod.GET)
	public String viewTransferByUser (){
		return "users/transfer";
	}
	
	@RequestMapping (value = "/user/viewTransferTarget", method=RequestMethod.GET)
	public ModelAndView viewTransferTarget (@ModelAttribute( value = "id") String id, 
			HttpServletRequest request, HttpServletResponse response){
		ModelAndView model = new ModelAndView("users/transferTarget");
		
		List<TargetAccount> targets = fundService.getTargetAccount(id);
		if (targets != null) {
			model.addObject("targetAccounts", targets);
		}
		
		return model;
	}
	
	
	@RequestMapping (value = "/user/transferByUser", method=RequestMethod.POST)
	@ResponseBody
	public String transferByUser (@ModelAttribute( value = "id") String id,
			HttpServletRequest request, HttpServletResponse response) {
		
		Account account = accountService.getAccountById(id);
		
		if (account == null) {
			return "Error";
		}
		
		String targetAccount = request.getParameter("targetAccount");
		BigDecimal amount = BigDecimal.valueOf(Long.parseLong(request.getParameter("amount")));
		
		boolean result = fundService.transfer(id, targetAccount, amount);
		
		if (result) {
			return "success";
		}
		return "Error";
	}
	
	@RequestMapping (value = "/user/transferTargetID", method=RequestMethod.POST)
	@ResponseBody
	public String transferTargetID(@ModelAttribute( value = "id") String id,
			HttpServletRequest request, HttpServletResponse response) {
		
		Account account = accountService.getAccountById(id);
		
		if (account == null) {
			return "Error";
		}
		
		String targetAccount = request.getParameter("targetAccount");
		BigDecimal amount = BigDecimal.valueOf(Long.parseLong(request.getParameter("amount")));
		
		boolean result = fundService.transferTargetID(id, targetAccount, amount);
		
		if (result) {
			return "success";
		}
		return "Error";
	}
	
	@RequestMapping (value = "/support/viewWithdraw", method = RequestMethod.GET)
	public String viewWithdraw() {
		return "support/withdraw";
	}
	
	@RequestMapping (value = "/support/withdraw", method = RequestMethod.POST)
	@ResponseBody
	public String withdraw(HttpServletRequest request, HttpServletResponse response) {
		
		String accountNumber = request.getParameter("accountNumber");
		BigDecimal amount = BigDecimal.valueOf(Long.parseLong(request.getParameter("amount")));
		
		boolean result = fundService.withdraw(accountNumber, amount);
		if (result) {
			return "success";
		} else {
			return "Error";
		}
	}
}
