package com.csc.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.csc.entities.Account;
import com.csc.entities.TargetAccount;
import com.csc.entities.Transaction;
import com.csc.entities.User;
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
		
//		System.out.println(account.getFirstName() + " "
//				+ account.getMidName() + " "
//				+ account.getLastName() + " "
//				+ account.getAddress1() + " "
//				+ account.getAddress2() + " "
//				+ account.getPhoneNum1() + " "
//				+ account.getPhoneNum2());
		
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
		
		boolean result = fundService.transfer(sendAccount, targetAccount, amount);
		
		if (result) {
			return "success";
		}
		return "Error";
	}
	
	@RequestMapping (value = "/viewTransferByUser", method=RequestMethod.GET)
	public String viewTransferByUser (){
		return "users/transfer";
	}
	
	@RequestMapping (value = "/viewTransferTarget", method=RequestMethod.GET)
	public ModelAndView viewTransferTarget (HttpServletRequest request, HttpServletResponse response){
		ModelAndView model = new ModelAndView("users/transferTarget");
		
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		
//		if (user != null) {
//			model.setViewName("forward:/home");
//			return model;
//		}
		
		List<TargetAccount> targets = fundService.getTargetAccount(user.getId());
		model.addObject("targetAccounts", targets);
		
		return model;
	}
	
	
	@RequestMapping (value = "/transferByUser", method=RequestMethod.POST)
	@ResponseBody
	public String transferByUser(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		User user = (User)session.getAttribute("user");
		
		if (user != null) {
			return "Error";
		}
		
		String targetAccount = request.getParameter("targetAccount");
		BigDecimal amount = BigDecimal.valueOf(Long.parseLong(request.getParameter("amount")));
		
		boolean result = fundService.transfer(user.getId(), targetAccount, amount);
		
		if (result) {
			return "success";
		}
		return "Error";
	}
	
	@RequestMapping (value = "/transferTargetID", method=RequestMethod.POST)
	@ResponseBody
	public String transferTargetID(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		User user = (User)session.getAttribute("user");
		
		if (user != null) {
			return "Error";
		}
		
		String targetAccount = request.getParameter("targetAccount");
		BigDecimal amount = BigDecimal.valueOf(Long.parseLong(request.getParameter("amount")));
		
		boolean result = fundService.transferTargetID(user.getId(), targetAccount, amount);
		
		if (result) {
			return "success";
		}
		return "Error";
	}
	
	@RequestMapping (value = "/viewWithdraw", method = RequestMethod.GET)
	public String viewWithdraw() {
		return "support/withdraw";
	}
	
	@RequestMapping (value = "/withdraw", method = RequestMethod.POST)
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
	
	@RequestMapping (value = "/verifyTransaction", method = RequestMethod.GET)
	public ModelAndView verifyTransaction(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = new ModelAndView("admin/verifyTransaction");
		
		List<Transaction> transactions = null;
		transactions = fundService.getNewTransaction();
		model.addObject("transactions", transactions);
		
		return model;
	}
	
}
