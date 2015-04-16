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

import com.csc.entities.User;
import com.csc.service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService userService;
	
	@RequestMapping (value = "/viewinfo", method = RequestMethod.GET)
	public String viewuserinfo(HttpServletRequest request, Model model){
		
		User user = userService.getUserInfo("123456789012");
		
		model.addAttribute("user", user);
		
		return "viewinfo";
		
	}
	
	@RequestMapping (value = "/changeUserPassword", method=RequestMethod.POST)
	@ResponseBody
	public String changePassword(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		
//		User user = (User)session.getAttribute("user");
//		
//		if (user != null) {
//			return "Error";
//		}
		
		String id = request.getParameter("id");
		String oldPassword = request.getParameter("password");
		String newPassword = request.getParameter("newPassword");
		
		return userService.changePassword(id, oldPassword, newPassword);		
		
	}
	
	@RequestMapping (value = "/editUserInfo", method=RequestMethod.POST)
	@ResponseBody
	public String editUserInfo(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		
//		User user = (User)session.getAttribute("user");
//		
//		if (user != null) {
//			return "Error";
//		}
		
		String id = request.getParameter("id");
		String firstName = request.getParameter("firstName");
		String midName = request.getParameter("midName");
		String lastName = request.getParameter("lastName");
		String address2 = request.getParameter("address2");
		String phone2 = request.getParameter("phone2");
		
		return userService.editUserInfo(id, firstName, midName, lastName, address2, phone2);		
		
	}
}

