package com.springmvc.demo.controller;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.springmvc.demo.bo.Menu;
import com.springmvc.demo.bo.MenuElement;

@Controller
@SessionAttributes("themeMode")
public class BaseController {
	
	@Autowired 
	private Menu menu;
	private String MENU_NAME = "Home";
	
	// Init Menu
		@PostConstruct
		private void initMenu() {
			MenuElement home = new MenuElement("Home", "menu-element", "/", "active");
			MenuElement dataBase = new MenuElement("Database", "menu-element","/database", "inactive");
			MenuElement sessionManagement = new MenuElement("Session Management", "menu-element","/session", "inactive");
			MenuElement dataValidation = new MenuElement("Data Validation", "menu-element","/datavalidation", "inactive");
			MenuElement logInRoles = new MenuElement("Log in & Roles Management", "menu-element","/login", "inactive");
			MenuElement contactMe = new MenuElement("Contact Me", "menu-element" ,"/contact", "inactive");
			menu.addAll(home,dataBase,sessionManagement,dataValidation,logInRoles,contactMe);
		}
		
		// Changes the current active button on the menu
		@ModelAttribute
		public void handleMenu() {
			menu.unactiveAll();
			menu.setActive(MENU_NAME);
		}
		
	
    @GetMapping("/")
    public String indexPage(HttpServletRequest request) {
        return "index";
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

