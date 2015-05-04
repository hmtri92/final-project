package com.csc.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.csc.entities.Account;
import com.csc.entities.StateResult;
import com.csc.entities.TargetAccount;
import com.csc.service.AccountService;
import com.csc.service.FundService;
import com.csc.service.UserService;

/**
 * 
 * @author MinhTri
 * @Method: addFund, transfer by support, transfer by user, transfer in target by User, withdraw
 */
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
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @return Account
	 * getAccountById: get infomation
	 */
	@RequestMapping (value = "/support/getAccountById", method={RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public Account getAccountById(HttpServletRequest request, HttpServletResponse response) {
		String accountNumber = request.getParameter("accountNumber");
		Account account = accountService.getAccountById(accountNumber);
		
		return account;
	}
	
	/**
	 * addFund by accountId, amount to account
	 * Use @ResponseBody: call by ajax
	 * @return: message
	 */
	@RequestMapping (value = "/support/addFund", method = RequestMethod.POST)
	@ResponseBody
	public String addFund(HttpServletRequest request, HttpServletResponse response) {
		
		String accountNumber = request.getParameter("accountNumber");
		BigDecimal amount = BigDecimal.valueOf(Long.parseLong(request.getParameter("amount")));
		
		StateResult result = fundService.addFund(accountNumber, amount);
		return result.getMessage();
	}
	
	@RequestMapping (value = "/support/viewTransferBySupport", method = RequestMethod.GET)
	public String goViewTranferBySupport() {
		return "support/transferNew";
	}
	
	/**
	 * Transfer by support
	 * @param sendAccount, targetAccount, amount
	 * @return: StateResult(Account not found!, Success or fail)
	 */
	@RequestMapping (value = "/support/transferBySupport", method=RequestMethod.POST)
	@ResponseBody
	public StateResult transferBySupport(HttpServletRequest request, HttpServletResponse response) {
		String sendAccount = request.getParameter("sendAccount");
		String targetAccount = request.getParameter("targetAccount");
		BigDecimal amount = BigDecimal.valueOf(Long.parseLong(request.getParameter("amount")));
		
		return fundService.transfer(sendAccount, targetAccount, amount);
	}
	
	@RequestMapping (value = "/user/viewTransferByUser", method=RequestMethod.GET)
	public String viewTransferByUser (){
		return "users/transfer";
	}
	
	/**
	 * 
	 * @param id
	 * @param request
	 * @param response
	 * @return: message result
	 */
	@RequestMapping (value = "/user/viewTransferTarget", method=RequestMethod.GET)
	public ModelAndView viewTransferTarget (@ModelAttribute( value = "id") String id, 
			HttpServletRequest request, HttpServletResponse response){
		ModelAndView model = new ModelAndView("users/transferTarget");
		
		List<TargetAccount> targets = fundService.getListTargetByAccountOwnerId(id);
		if (targets != null) {
			model.addObject("targetAccounts", targets);
		}
		
		return model;
	}
	
	/**
	 * Ajax call
	 * Transfer by user, get idUser in session, targetAccount and amount from client
	 * @return: StateResult(Account not found!, Success or fail)
	 */
	@RequestMapping (value = "/user/transferByUser", method=RequestMethod.POST)
	@ResponseBody
	public StateResult transferByUser (@ModelAttribute( value = "id") String id,
			HttpServletRequest request, HttpServletResponse response) {
		String targetAccount = request.getParameter("targetAccount");
		BigDecimal amount = BigDecimal.valueOf(Long.parseLong(request.getParameter("amount")));
		
		return fundService.transfer(id, targetAccount, amount);
	}
	
	/**
	 * 
	 * @param id
	 * @param request
	 * @param response
	 * @return: StateResult(Account not found!, Success or fail)
	 */
	@RequestMapping (value = "/user/transferTargetID", method=RequestMethod.POST)
	@ResponseBody
	public StateResult transferTargetID(@ModelAttribute( value = "id") String id,
			HttpServletRequest request, HttpServletResponse response) {
		String targetAccount = request.getParameter("targetAccount");
		BigDecimal amount = BigDecimal.valueOf(Long.parseLong(request.getParameter("amount")));
		
		return fundService.transferTargetID(id, targetAccount, amount);
	}
	
	@RequestMapping (value = "/support/viewWithdraw", method = RequestMethod.GET)
	public String viewWithdraw() {
		return "support/withdraw";
	}
	
	/**
	 * By support
	 * get accountNumber, amount from client
	 * @return StateResult
	 * 	if availableAmount - sendAmount < 50000 return: The amount in the account is not enough to transfer
	 * 	if Account not active return: Account is not ACTIVE
	 * 	if account not found return: Account not found!
	 * 	if success return: Success.
	 */
	@RequestMapping (value = "/support/withdraw", method = RequestMethod.POST)
	@ResponseBody
	public StateResult withdraw(HttpServletRequest request, HttpServletResponse response) {
		String accountNumber = request.getParameter("accountNumber");
		BigDecimal amount = BigDecimal.valueOf(Long.parseLong(request.getParameter("amount")));
		
		return fundService.withdraw(accountNumber, amount);
	}
}
