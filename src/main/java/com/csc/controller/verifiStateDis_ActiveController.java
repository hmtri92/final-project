package com.csc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.csc.entities.Account;
import com.csc.service.AccountService;
//chuyen tu dis sang remove
@Controller
@SessionAttributes({ "username", "role" })
public class verifiStateDis_ActiveController
 {
	@Autowired
	AccountService accountService;

	@RequestMapping(value = "/support/change_State_Dis-Active", method = { RequestMethod.GET,
			RequestMethod.POST })
	public ModelAndView changeState(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView model = new ModelAndView("support/verifiDis-Active");

		List<Account> account = null;
		account = accountService.getStateDis();
		model.addObject("listAccount", account);

		return model;

	}

	@RequestMapping(value = "/support/doVerifyStateDis-Active", method = { RequestMethod.GET,
			RequestMethod.POST })
	@ResponseBody
	public boolean dochangeState(HttpServletRequest request,
			HttpServletResponse response, Model model) {

		try {
			String id = request.getParameter("id");
			int state = 2;// State 2 la chuyen ve 2
			Account existedAccount = accountService.getAccountById(id);
			
			if (existedAccount == null) {
				return false;
			} else {
				Account account = accountService.updateStateAccountById(id, state);
				
				if (account.getState().getIdState() == state) {
					return true;
				} else {
					return false;
				}
			}
			
		} catch (Exception e) {
			return false;
		}
	}
}
