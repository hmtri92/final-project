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
@SessionAttributes({ "username", "role" })
public class verifyActive_DisableController {

	@Autowired
	AccountService accountService;

	@RequestMapping(value = "/support/change_State_Active-Dis", method = RequestMethod.GET)
	public ModelAndView verifyStateActive(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView model = new ModelAndView("support/verifiActive-Dis");

		List<Account> listState = null;
		listState = accountService.getStateActive();
		model.addObject("listState", listState);

		return model;
	}

	@RequestMapping(value = "support/doVerifyStateActive", method = RequestMethod.POST)
	@ResponseBody
	public Account doVerifyStateActive(HttpServletRequest request,
			HttpServletResponse response) {
		String id = request.getParameter("id");
		int state = 3;
		return accountService.updateStateAccountById(id, state);
	}
}
