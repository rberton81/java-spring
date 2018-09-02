package com.springmvc.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.demo.bo.Menu;

@Controller
@SessionAttributes("thought")
@RequestMapping(path = "/session") // This means URL's start with /h2db (after Application path)
public class SessionController {
	private String ROOT_FOLDER = "session/";
	private String MENU_NAME = "Session Management";
	
	@Autowired
	private Menu menu;
	
	// Changes the current active button on the menu
	@ModelAttribute
	public void handleMenu() {
		menu.unactiveAll();
		menu.setActive(MENU_NAME);
	}
	
	@RequestMapping(value="")
	public ModelAndView singleFieldPage(WebRequest request, SessionStatus status, HttpSession session) {
		return new ModelAndView(ROOT_FOLDER + "session-index");
	}
	
	@RequestMapping(value="/session-cleanup")
	public ModelAndView cleanUpSession(WebRequest request, SessionStatus status, HttpSession session) {
		status.setComplete();
		return new ModelAndView(ROOT_FOLDER + "session-index");
	}
	
	
	@RequestMapping(value="/session-form")
	public ModelAndView sessionFormPage() {
		return new ModelAndView(ROOT_FOLDER + "session-form");
	}
	
	
	@RequestMapping(value="/remember")	
	public ModelAndView rememberThought(@RequestParam String thoughtParam) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("thought", thoughtParam);
		modelAndView.setViewName(ROOT_FOLDER + "session-form");
		return modelAndView;
	}
	
}