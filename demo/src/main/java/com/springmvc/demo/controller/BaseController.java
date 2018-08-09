package com.springmvc.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("themeMode")
public class BaseController {
	
    @GetMapping("/")
    public String indexPage(HttpServletRequest request) {
        return "index";
    }
	
    @GetMapping("/contact")
    public String contactPage() {
        return "contact/index";
    }
    
    @GetMapping("/error")
    public String errorPage() {
        return "error";
    }
    

    @RequestMapping("/themeMode")
    public ModelAndView themeModeHandling(String mode) {
    	ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("themeMode", mode);
		modelAndView.setViewName("index");
        return modelAndView;
    }
}