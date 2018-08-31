package com.springmvc.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.demo.bo.User;
import com.springmvc.demo.bo.UserRepository;

@Controller // This means that this class is a Controller
@RequestMapping(path = "/h2db") // This means URL's start with /h2db (after Application path)
public class UserController {
	private String ROOT_FOLDER = "h2db/";
	@Autowired // This means to get the bean called userRepository
				// Which is auto-generated by Spring, we will use it to handle the data
	private UserRepository userRepository;

	// Index page
	@GetMapping("/index")
	public ModelAndView index(String message, Model model) {
		if (message != null) {
			model.addAttribute("message", message);
		} else {
			model.addAttribute("message", "");
		}
		return new ModelAndView(ROOT_FOLDER + "h2dbindex", "user", new User());
	}

	@RequestMapping(value = "/getAll")
	public @ResponseBody Iterable<User> getAllUsersAjax() {
		// AjaxResponseBody will be converted into json format and send back to the
		// request.
		return userRepository.findAll();

	}

}