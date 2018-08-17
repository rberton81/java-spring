package com.springmvc.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.springmvc.demo.bo.AjaxResponseBody;

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
    public RedirectView themeModeHandling(String mode, String urlFrom, Model model, @ModelAttribute("themeMode") String themeMode, HttpServletRequest request) {
    	if(!themeMode.equals(mode)) {
    		model.addAttribute("themeMode", mode);
    	}
        return new RedirectView(urlFrom);
    }
    
    @ModelAttribute("themeMode")
    public String themeMode() {
        return "day";
    }
}