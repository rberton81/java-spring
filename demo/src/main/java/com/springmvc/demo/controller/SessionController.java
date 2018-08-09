package com.springmvc.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("thought")
public class SessionController {
	
	@RequestMapping(value="/sessionIndex")
	public ModelAndView singleFieldPage(WebRequest request, SessionStatus status, HttpSession session) {
		return new ModelAndView("session-index");
	}
	
	@RequestMapping(value="/session-cleanup")
	public ModelAndView cleanUpSession(WebRequest request, SessionStatus status, HttpSession session) {
		status.setComplete();
		return new ModelAndView("session-index");
	}
	
	
	@RequestMapping(value="/session-form")
	public ModelAndView sessionFormPage() {
		return new ModelAndView("session-form");
	}
	
	
	@RequestMapping(value="/remember")	
	public ModelAndView rememberThought(@RequestParam String thoughtParam) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("thought", thoughtParam);
		modelAndView.setViewName("session-form");
		return modelAndView;
	}
	
}