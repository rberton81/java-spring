package com.springmvc.demo.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springmvc.demo.bo.NumbersSumForm;


@Controller // This means that this class is a Controller
@RequestMapping(path = "/dataValidation") // This means URL's start with /h2db (after Application path)
public class DataValidationController {
	private String ROOT_FOLDER = "dataValidation/";
	
	// Index page
	@GetMapping("/index")
	public String getIndex(NumbersSumForm numbersSumForm) {
		return ROOT_FOLDER + "dataValidationIndex";
	}
	
	// Index page
		@PostMapping("/index")
		public String postIndex(@Valid NumbersSumForm numbersSumForm, BindingResult bindingResult) {
			Integer number1 = numbersSumForm.getNumber1();
			Integer number2 = numbersSumForm.getNumber2();
			Integer sum = numbersSumForm.getSum();
			if(number1 != null && number2 != null && sum != null) {
				Integer realSum = number1 + number2;
				if(sum != realSum) {
					bindingResult.rejectValue("sum", "testerror code", "Seems your maths are not so good... The correct result was : " + realSum);
				}	
			}
			
	        if (bindingResult.hasErrors()) {
		        System.out.println("ca passe ici");
	            return ROOT_FOLDER + "dataValidationIndex";
	        }
	        
	        numbersSumForm.setMessage("Good job, a healthy brain in a healthy body is important!");
			return ROOT_FOLDER + "dataValidationIndex";
		}


}