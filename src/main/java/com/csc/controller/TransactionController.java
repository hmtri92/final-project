package com.csc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.csc.entities.Transaction;
import com.csc.service.FundService;

@Controller
public class TransactionController {

	@Autowired
	FundService fundService;
	
	@RequestMapping (value = "/viewVerifyTransaction", method = RequestMethod.GET)
	public ModelAndView verifyTransaction(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = new ModelAndView("admin/verifyTransaction");
		
		List<Transaction> transactions = null;
		transactions = fundService.getNewTransaction();
		model.addObject("transactions", transactions);
		
		return model;
	}
	
	@RequestMapping (value = "verifyTransaction", method = RequestMethod.POST)
	@ResponseBody
	public String doVerifyTransaction(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("idTransaction");
		long idTransaction = Long.parseLong(request.getParameter("idTransaction").trim());
		boolean result = fundService.verifyTransaction(idTransaction);
		if (result == true) {
			return "success";
		} else {
			return "fail";
		}
	}
}
