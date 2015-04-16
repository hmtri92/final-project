package com.csc.controller;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.csc.entities.Account;
import com.csc.service.AccountService;
import com.csc.service.FundService;


@Controller
public class AccountController {
	@Autowired
	AccountService accountService;

	public ModelAndView AccountPage() {
		 
		ModelAndView model = new ModelAndView();
		model.setViewName("support/addAccount");
 
		return model;
 
	}
	@RequestMapping(value = "/createAccount", method = RequestMethod.GET)
	public String goViewAddFund2() {
		return "support/addAccount";
	}

	@RequestMapping(value = "/docreateAccount", method = RequestMethod.POST)
	public String addAccount(HttpServletRequest request,
			HttpServletResponse response,Model model) {

		String accountNumber = request.getParameter("id");
//		BigDecimal amount = BigDecimal.valueOf(Long.parseLong(request
//				.getParameter("availableAmount")));
		BigDecimal amount = BigDecimal.valueOf(0);
		String idCardNumber = request.getParameter("idCardNumber");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String midName = request.getParameter("midName");
		String phoneNum1 = request.getParameter("phoneNum1");
		String phoneNum2 = request.getParameter("phoneNum2");
		String address1 = request.getParameter("address1");
		String address2 = request.getParameter("address2");
		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2");
		String stat = request.getParameter("state");
		int state = Integer.parseInt(stat);
		String rol = request.getParameter("role");
		int role = Integer.parseInt(rol);
		String typeAccount1 = request.getParameter("typeAccount");
		int typeAccount = Integer.parseInt(typeAccount1);

		Account account = new Account();
		account.setId(accountNumber);
		account.setAvailableAmount(amount);
		account.setIdCardNumber(idCardNumber);
		account.setFirstName(firstName);
		account.setLastName(lastName);
		account.setMidName(midName);
		account.setAddress1(address1);
		account.setAddress2(address2);
		account.setEmail1(email1);
		account.setEmail2(email2);
		account.setPhoneNum1(phoneNum1);
		account.setPhoneNum2(phoneNum2);
		
		Account existedAccount = accountService.getAccountById(accountNumber);	
		
		if (existedAccount==null) {
			accountService.addAccount(account, role, typeAccount);
			model.addAttribute("message", "Create Account Success!");
			return "support/addAccount";

			
		} else {
			model.addAttribute("message", "Create Account Fail!");
			return "support/addAccount";

		}
	}

}
