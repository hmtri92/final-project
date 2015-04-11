package com.csc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.csc.ultil.CreateDatabase;

@Controller
public class CreateDBController {

	@Autowired
	CreateDatabase db;
	
	@RequestMapping( value = "/createDB", method = RequestMethod.GET)
	public String createDB() {
		
		db.createRole();
		db.createState();
		db.createTypeAccount();		
		db.createAccount();
//		db.createUser();
		
		return "forward:login";
	}
}
