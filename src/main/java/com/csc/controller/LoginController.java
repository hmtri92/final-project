package com.csc.controller;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.csc.entities.User;
import com.csc.service.AccountService;
import com.csc.service.UserService;

/**
 * 
 * @author MinhTri
 * Login success and goHome
 *
 */
@Controller
@SessionAttributes({ "username", "role", "id", "countLogin", "user" })
public class LoginController {

	@Autowired
	UserService userService;
	
	@Autowired
	AccountService accountService;
	
	private Logger logger = Logger.getLogger(LoginController.class);

	@RequestMapping(value = "/login", method = { RequestMethod.GET, RequestMethod.POST })
	public String doLogin() {
		return "login_soft";
	}

	/**
	 * set Session attributes
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/home")
	public String goHome(HttpServletRequest request, Model model) {
		logger.info("Go Home!");
		
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
		
		// Set attempts 0
		userEntity.setAttempts(0);
		userService.editUserprofile(userEntity);
		
		// unlock session
		model.addAttribute("countLogin", 0);
		

		// set role attribute
		if (authorities.toString().contains("ROLE_ADMIN")) {
			model.addAttribute("role", "admin");

		} else if (authorities.toString().contains("USER_SUPPORT")) {
			model.addAttribute("role", "user_support");

		} else if (authorities.toString().contains("CUSTOMER")) {
			model.addAttribute("role", "customer");
		} else if (authorities.toString().contains("REPORT_SUPPORT")) {
			model.addAttribute("role", "report_support");

		} else if (authorities.toString().contains("ACCOUNT_SUPPORT")) {
			model.addAttribute("role", "account_support");
		}

		model.addAttribute("user", userEntity);

		return "forward:/userhome";
	}

	@RequestMapping(value = {"/userhome","user/userHome","admin/userhome","support/userhome"}, 
			method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView goHome() {
		ModelAndView model = new ModelAndView("home");

		return model;
	}
	
	/**
	 * 
	 * @param request
	 * @param model
	 * @return login_soft.jsp
	 */
	@RequestMapping (value = "/loginfail", method = { RequestMethod.GET, RequestMethod.POST})
	public String loginFail(HttpServletRequest request, Model model) {

		int countLogin = 0;
		try {
			countLogin = (int) request.getSession().getAttribute("countLogin");
			countLogin++;
		} catch (NullPointerException e) {
			countLogin = 1;
		}
		model.addAttribute("countLogin", countLogin);
		
		return "login_soft";
	}

}
