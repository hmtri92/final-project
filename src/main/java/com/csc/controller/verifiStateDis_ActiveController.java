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
public class verifiStateDis_ActiveController {

	@Autowired
	AccountService accountService;

	@RequestMapping(value = "/support/change_State_Dis-Active", method = RequestMethod.GET)
	public ModelAndView verifyStateDis(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView model = new ModelAndView("support/verifiDis-Active");

		List<Account> listState = null;
		listState = accountService.getStateDis();
		model.addObject("listState", listState);

		return model;
	}

	@RequestMapping(value = "/support/doVerifyStateDis-Active", method = RequestMethod.POST)
	@ResponseBody
	public Account doVerifyStateDis(HttpServletRequest request,
			HttpServletResponse response) {
		String id = request.getParameter("id");
		int state = 2;
		return accountService.updateStateAccountById(id, state);
	}
}
