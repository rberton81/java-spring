package com.springmvc.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springmvc.demo.bo.Menu;


@Controller // This means that this class is a Controller
@RequestMapping(path = "/login") // This means URL's start with /h2db (after Application path)
public class LoginController {
	private String ROOT_FOLDER = "login/";
	private String MENU_NAME = "Log in & Roles Management";
	
	@Autowired
	private Menu menu;
	
	// Changes the current active button on the menu
	@ModelAttribute
	public void handleMenu() {
		menu.unactiveAll();
		menu.setActive(MENU_NAME);
	}
	
	// Index page
	@GetMapping("")
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