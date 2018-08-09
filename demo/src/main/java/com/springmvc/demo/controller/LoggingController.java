package com.springmvc.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller // This means that this class is a Controller
@RequestMapping(path = "/logging") // This means URL's start with /h2db (after Application path)
public class LoggingController {
	private String ROOT_FOLDER = "logging/";
	
	
	// Index page
	@GetMapping("/index")
	public String getIndexPage() {
		return ROOT_FOLDER + "loggingIndex";
	}
	
	// Log in page
	@GetMapping("/login")
	public String getLogInPage() {
		return ROOT_FOLDER + "logginglogin";
	}
	
	// Sign in page
	@GetMapping("/signin")
	public String getSignInPage() {
		return ROOT_FOLDER + "loggingsignin";
	}


}