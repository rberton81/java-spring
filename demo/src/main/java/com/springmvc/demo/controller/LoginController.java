package com.springmvc.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller // This means that this class is a Controller
@RequestMapping(path = "/login") // This means URL's start with /h2db (after Application path)
public class LoginController {
	private String ROOT_FOLDER = "login/";
	
	
	// Index page
	@GetMapping("/index")
	public String getIndexPage() {
		return ROOT_FOLDER + "loginIndex";
	}
	
	// Log in page
	@GetMapping("/login")
	public String getLogInPage() {
		return ROOT_FOLDER + "loginlogin";
	}
	
	// Sign in page
	@GetMapping("/signin")
	public String getSignInPage() {
		return ROOT_FOLDER + "loginsignin";
	}

	// Log in testing page
	@GetMapping("/logintest")
	public String getLogInTestPage() {
		return ROOT_FOLDER + "logintest";
	}

}