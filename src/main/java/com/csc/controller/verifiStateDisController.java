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
import com.csc.service.AccountService;

@Controller
@SessionAttributes({ "username", "role" })
public class verifiStateDisController {
	@Autowired
	AccountService accountService;

	@RequestMapping(value = "/admin/verifyStateDis", method = { RequestMethod.GET,
			RequestMethod.POST })
	public ModelAndView updateVerifyState(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView model = new ModelAndView("admin/verifyStateDis");

		List<Account> account = null;
		account = accountService.getStateDis();
		model.addObject("listAccount", account);

		return model;

	}

	@RequestMapping(value = "/admin/doVerifyStateDis", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String addAccount(HttpServletRequest request,
			HttpServletResponse response, Model model) {

		String accountNumber = request.getParameter("accountNumber");
		int state = 4;
		Account existedAccount = accountService.getAccountById(accountNumber);

		if (existedAccount == null) {
			model.addAttribute("message", "This account is not valid");

		} else {
			accountService.updateStateAccountById(accountNumber, state);
			model.addAttribute("message", "This account have been  modified");

		}
		return "forward:verifyStateDis";
	}
}
