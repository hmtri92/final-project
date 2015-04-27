package com.csc.controller;

import java.math.BigDecimal;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.csc.entities.User;
import com.csc.service.AccountService;
import com.csc.service.UserService;

@Controller
@SessionAttributes({ "username", "role", "id", "availableAmount" })
public class LoginController {

	@Autowired
	UserService userService;
	
	@Autowired
	AccountService accountService;
	
	private Logger logger = Logger.getLogger(LoginController.class);

	@RequestMapping(value = "/login", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String doLogin() {
		return "login_soft";
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

	@RequestMapping(value = "/home")
	public String goHome(HttpServletRequest request, Model model) {
		logger.info("Go Home!");
		String url = "";
		// Get username - add session user
		org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();
		// ID user in db
		String id = user.getUsername();

		User userEntity = userService.getUserByID(id);

		// Set session user
		model.addAttribute("username", userEntity.getLoginID());
		model.addAttribute("id", id);
		// Get role - add session rolesuser
		Collection<GrantedAuthority> authorities = user.getAuthorities();
		
		// Set attempts
		userEntity.setAttempts(0);
		userService.editUserprofile(userEntity);
		

		// Redirect

		if (authorities.toString().contains("ROLE_ADMIN")) {
			model.addAttribute("role", "admin");

		} else if (authorities.toString().contains("USER_SUPPORT")) {
			model.addAttribute("role", "user_support");

		} else if (authorities.toString().contains("CUSTOMER")) {
			model.addAttribute("role", "customer");

			try {
				BigDecimal availableAmount = accountService.getAccountById(id)
						.getAvailableAmount();
				model.addAttribute("availableAmount",
						availableAmount.toString());
			} catch (Exception e) {
				model.addAttribute("availableAmount", "0");
			}

		} else if (authorities.toString().contains("REPORT_SUPPORT")) {
			model.addAttribute("role", "report_support");

		} else if (authorities.toString().contains("ACCOUNT_SUPPORT")) {
			model.addAttribute("role", "account_support");
		}

		model.addAttribute("user", userEntity);
		url = "forward:/userhome";

		return url;
	}

	@RequestMapping(value = "/404", method = { RequestMethod.GET, RequestMethod.POST })
	public String error404() {
		return "404";
	}
	@RequestMapping(value = "/500", method = { RequestMethod.GET, RequestMethod.POST })
	public String error500() {
		return "500";
	}

	@RequestMapping(value = "/userhome", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView goHome() {
		ModelAndView model = new ModelAndView("home");

		return model;
	}
	
	@RequestMapping (value = "/loginfail", method = { RequestMethod.GET, RequestMethod.POST})
	public String loginFail( @ModelAttribute( value = "id") String id, HttpServletRequest request, Model model) {

		User userEntity = userService.getUserByID(id);
		
		
		return "login_soft";
	}

}
