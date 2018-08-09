package com.springmvc.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BaseController {

    @GetMapping("/contact")
    public String contactPage() {
        return "contact";
    }
    
    @GetMapping("/error")
    public String errorPage() {
        return "error";
    }
    
}