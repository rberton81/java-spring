package com.springmvc.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller // This means that this class is a Controller
@RequestMapping(path = "/logging") // This means URL's start with /h2db (after Application path)
public class LoggingController {

	// Index page
	@GetMapping("/index")
	public String getIndex() {
		return "loggingIndex";
	}
	
	// Index page


}