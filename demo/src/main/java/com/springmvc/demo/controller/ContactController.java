package com.springmvc.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.springmvc.demo.bo.Menu;

@Controller
public class ContactController {

	@Autowired
	private Menu menu;
	private String MENU_NAME = "Contact Me";

	// Changes the current active button on the menu
	@ModelAttribute
	public void handleMenu() {
		menu.unactiveAll();
		menu.setActive(MENU_NAME);
	}

	@GetMapping("/contact")
	public String contactPage() {
		return "contact/index";
	}
}
