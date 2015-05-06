package com.csc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.csc.entities.BalanceAmount;
import com.csc.entities.Role;
import com.csc.entities.TransactionHistory;
import com.csc.entities.User;
import com.csc.service.UserService;

/**
 * Handle services for user
 * @author Phuc Doan
 *
 */
@Controller
@SessionAttributes({ "username", "role", "id" })
public class UserController {
	@Autowired
	UserService userService;
	
	/**
	 * Handles changing password request
	 * @param request
	 * @param response
	 * @return String represent the result of changing password
	 */
			
	@RequestMapping (value = "/changeUserPassword", method=RequestMethod.POST)
	@ResponseBody
	public String changePassword(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();

		String role = (String) session.getAttribute("role");
		
		String userID = null;
		
		if (role == "account_support" || role == "admin") {
			userID = request.getParameter("id");
			if (userID == null) {
				return "FAIL: Error while processing request...";
			}
		} else {
			userID = (String) session.getAttribute("id");
		}
		
		String oldPassword = request.getParameter("password");
		String newPassword = request.getParameter("newPassword");
		
		return userService.changePassword(userID, oldPassword, newPassword);		
		
	}
	
	/**
	 * Handles editing information request
	 * @param request
	 * @param response
	 * @return String represent the result of editing
	 */
	@RequestMapping (value = "/editUserInfo", method=RequestMethod.POST)
	@ResponseBody
	public String editUserInfo(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();

		String role = (String) session.getAttribute("role");
		
		String userID = null;
		
		if (role == "account_support" || role == "admin") {
			userID = request.getParameter("id");
			if (userID == null) {
				return "FAIL: Error while processing request...";
			}
		} else {
			userID = (String) session.getAttribute("id");
		}
		
		String firstName = request.getParameter("firstName");
		String midName = request.getParameter("midName");
		String lastName = request.getParameter("lastName");
		String address2 = request.getParameter("address2");
		String phone2 = request.getParameter("phone2");
		String email2 = request.getParameter("email2");
		
		return userService.editUserInfo(userID, firstName, midName, lastName, address2, phone2, email2);			
	}
	
	/**
	 * Handles viewing profile page request
	 * @param request
	 * @param model
	 * @return view profile page
	 */
	@RequestMapping (value = "/viewprofile")
	public String viewProfile(HttpServletRequest request, Model model){
		HttpSession session = request.getSession();
		
		String role = (String) session.getAttribute("role");
		
		String userID = null;
		
		if (role == "account_support" || role == "admin") {
			userID = request.getParameter("chosenaccount");
			if (userID == null) {
				userID = (String) session.getAttribute("id");
			}
		} else {
			userID = (String) session.getAttribute("id");
		}
		
		User user = userService.getUserByID(userID);
		
		model.addAttribute("user", user);
		
		return "viewprofile";
	}
	
	/**
	 * Handles viewing transaction log request
	 * @param request
	 * @param model
	 * @return Transaction log page
	 */
	@RequestMapping (value = "/user/viewlog", method = RequestMethod.GET)
	public String viewuserlog(HttpServletRequest request, Model model){
		HttpSession session = request.getSession();
		
		String role = (String) session.getAttribute("role");
		
		String userID = null;
		
		if (role == "account_support" || role == "admin") {
			userID = request.getParameter("chosenaccount");
			if (userID == null) {
				return "support/searchaccount";
			}
		} else {
			userID = (String) session.getAttribute("id");
		}
				
		List<TransactionHistory> listTransaction = null;
		
		listTransaction = userService.getTransactionByUserId(userID);
		
		model.addAttribute("userId", userID);
		if (listTransaction == null) {
			model.addAttribute("listTransaction", new ArrayList<TransactionHistory>());
			model.addAttribute("RESULT", "No result found");
		}else{
			model.addAttribute("listTransaction", listTransaction);
			model.addAttribute("RESULT", listTransaction.size() + " result(s) found");
		}
		
				
		return "users/viewlog";
		
	}
	
	
	/**
	 * Handles viewing balance history request
	 * @param request
	 * @param model
	 * @return balance history page
	 */
	@RequestMapping (value = "/user/viewbalance", method = RequestMethod.GET)
	public String viewbalancelog(HttpServletRequest request, Model model){
		
		HttpSession session = request.getSession();
		
		String role = (String) session.getAttribute("role");

		String userID = null;
		
		if (role == "account_support" || role == "admin") {
			userID = request.getParameter("chosenaccount");
			if (userID == null) {
				return "support/searchaccount";
			}
		} else {
			userID = (String) session.getAttribute("id");
		}
		
		List<BalanceAmount> listBalance = null;
		
		listBalance = userService.getBalanceLogByUserId(userID);
		
		
		model.addAttribute("accountNumber", userID);
		if (listBalance == null) {
			model.addAttribute("listBalance", new ArrayList<BalanceAmount>());
			model.addAttribute("RESULT", "No result found");
		}else{
			model.addAttribute("listBalance", listBalance);
			model.addAttribute("RESULT", listBalance.size() + " result(s) found");
		}
				
		return "users/viewbalance";
		
	}
	
	/**
	 * Handles get transaction log by date range
	 * @param request
	 * @param response
	 * @return transaction log data table
	 */
	@RequestMapping (value = "/user/getTransactionLog", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView getTransactionLog(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		String role = (String) session.getAttribute("role");
		
		String userID = null;
		
		if (role == "account_support" || role == "admin") {
			userID = request.getParameter("chosenaccount");			
		} else {
			userID = (String) session.getAttribute("id");
		}
		
		List<TransactionHistory> listTransaction = null;
		
		String stringDateFrom = request.getParameter("dateFrom");
		String stringDateTo = request.getParameter("dateTo");
				
		listTransaction = userService.getTransactionByDateRange(userID, stringDateFrom, stringDateTo);	
		
			
		ModelAndView modelnview = new ModelAndView("/models/transactiontable");
		
		if (listTransaction == null) {
			modelnview.addObject("listTransaction", new ArrayList<TransactionHistory>());
			modelnview.addObject("RESULT", "No result found");
		}else{
			modelnview.addObject("listTransaction", listTransaction);
			modelnview.addObject("RESULT", listTransaction.size() + " result(s) found");
		}
		
		return modelnview;
	}
	
	/**
	 * Handles get balance history by date range
	 * @param request
	 * @param response
	 * @return balance history data table
	 */
	@RequestMapping (value = "/user/getBalanceLog", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView getBalanceLog(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		String role = (String) session.getAttribute("role");
		
		String userID = null;
		
		if (role == "account_support" || role == "admin") {
			userID = request.getParameter("chosenaccount");			
		} else {
			userID = (String) session.getAttribute("id");
		}
		
		List<BalanceAmount> listBalance = null;
		
		String stringDateFrom = request.getParameter("dateFrom");
		String stringDateTo = request.getParameter("dateTo");
		
		listBalance = userService.getBalanceByDateRange(userID, stringDateFrom, stringDateTo);	
		
		
		ModelAndView modelnview = new ModelAndView("/models/balancetable");
		
		if (listBalance == null) {
			modelnview.addObject("listBalance", new ArrayList<BalanceAmount>());
			modelnview.addObject("RESULT", "No result found");
		}else{
			modelnview.addObject("listBalance", listBalance);
			modelnview.addObject("RESULT", listBalance.size() + " result(s) found");
		}
		
		return modelnview;
	}
}

