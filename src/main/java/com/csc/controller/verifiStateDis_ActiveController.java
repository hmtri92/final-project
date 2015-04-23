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
@SessionAttributes({ "username", "role", "id" })
public class verifiStateDis_ActiveController {
	@Autowired
	AccountService accountService;

	@RequestMapping(value = "/support/verifyStateDis-Active", method = { RequestMethod.GET,
			RequestMethod.POST })
	public ModelAndView updateVerifyStateDis(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView model = new ModelAndView("support/verifiDis-Active");

		List<Account> account = null;
		account = accountService.getStateDis();
		model.addObject("listAccount", account);

		return model;

	}

	@RequestMapping(value = "/support/doVerifyStateDis-Active", method = RequestMethod.POST)
	public String addAccount(HttpServletRequest request,
			HttpServletResponse response, Model model) {

		String accountNumber = request.getParameter("accountNumber");
		int state = 2;
		Account existedAccount = accountService.getAccountById(accountNumber);

		if (existedAccount == null) {
			model.addAttribute("message", "This account is not valid");

		} else {
			accountService.updateStateAccountById(accountNumber, state);
			model.addAttribute("message", "This account have been  modified");

		}
		return "forward:verifyStateDis-Active";
	}
}
