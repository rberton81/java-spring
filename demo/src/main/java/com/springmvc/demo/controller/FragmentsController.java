package com.springmvc.demo.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FragmentsController {
 
    @GetMapping("/fragments")
    public String getHome() {
        return "fragments.html";
    }
 
    @GetMapping("/header")
    public String markupPage() {
        return "header.html";
    }
 
    @GetMapping("/menu")
    public String paramsPage() {
        return "menu.html";
    }
}