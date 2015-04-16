package com.csc.controller;

import java.util.Collection;

import org.apache.log4j.Logger;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;


@Controller
@SessionAttributes({"username", "role" })
public class LoginController {
	
//	@Autowired
//	AuthenticationDAO authenticationDao;
	
	private Logger logger = Logger.getLogger(LoginController.class);

	@RequestMapping (value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
	public String doLogin() {
		return "login";
	}
	
	@RequestMapping(value = "/admin/admin", method = RequestMethod.GET)
	public ModelAndView adminPage() {
 
		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Hello World");
		model.addObject("message", "This is protected page!");
		model.setViewName("admin/admin");
 
		return model;
 
	}
	
	@RequestMapping(value = "/logoutsuccess", method = RequestMethod.GET)
	public String goLogoutSuccess(Model model) {
		logger.info("Logout Success!");
		return "login";
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String goHome(Model model) {
		logger.info("Go Home!");
		String url = "";
		// Get username - add session user
		org.springframework.security.core.userdetails.User user = 
				(org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		String username = user.getUsername();

		// Set session user
		model.addAttribute("username", username);
		// Get role - add session rolesuser
		Collection<GrantedAuthority> authorities = user.getAuthorities();

		// Redirect
		
		if (authorities.toString().contains("ROLE_ADMIN")) {
			model.addAttribute("role", "admin");
			url = "admin/home-admin";
		} else if (authorities.toString().contains("USER_SUPPORT")){
			model.addAttribute("role", "user_support");
			url = "support/home-support";
			
		} else if (authorities.toString().contains("CUSTOMER")) {
			model.addAttribute("role", "customer");
			url = "user/home-user";
			
		} else if (authorities.toString().contains("REPORT_SUPPORT")) {
			model.addAttribute("role", "report_support");
			url = "support/home-support";
			
		} else if (authorities.toString().contains("ACCOUNT_SUPPORT")) {
			model.addAttribute("role", "account_support");
			url = "support/home-support";
		}

		return url;
	}
	
	@RequestMapping(value = "/403", method = {RequestMethod.GET, RequestMethod.POST})
	public String error() {
		return "403";
	}
	
}
