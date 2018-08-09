package com.springmvc.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.springmvc.demo.bo.AjaxResponseBody;
import com.springmvc.demo.bo.SearchCriteria;
import com.springmvc.demo.bo.User;
import com.springmvc.demo.bo.UserRepository;
import com.springmvc.demo.bo.Views;

@RestController
public class AjaxController {
	@Autowired // This means to get the bean called userRepository
	// Which is auto-generated by Spring, we will use it to handle the data
	private UserRepository userRepository;
	private List<User> users;

	// @ResponseBody, not necessary, since class is annotated with @RestController
	// @RequestBody - Convert the json data into object (SearchCriteria) mapped by
	// field name.
	// @JsonView(Views.Public.class) - Optional, filters json data to display.
	@JsonView(Views.Public.class)
	@RequestMapping(value = "/h2db/addAjax")
	public AjaxResponseBody getSearchResultViaAjax(@RequestBody SearchCriteria search) {

		AjaxResponseBody result = new AjaxResponseBody();

		// Check if exists before adding
		if (isValidSearchCriteria(search)) {

			User n = new User(search.getUsername(), search.getEmail());
			List<User> usersQuery = userRepository.findByNameAndEmail(n.getName(), n.getEmail());
			System.out.println(usersQuery);
			System.out.println(usersQuery.size());
			if (usersQuery.isEmpty()) {
				User response = userRepository.save(n);
				if (response != null) {
					result.setCode("200");
					result.setMsg("The user has successfully been added to the database!");
					result.setResult(response);
				} else {
					result.setCode("204");
					result.setMsg("No user!");
				}
			} else {
				result.setCode("210");
				result.setMsg("User already existing in base!");
				result.setResult(usersQuery.get(0));
			}
		} else {
			result.setCode("400");
			result.setMsg("At least one of the search criteria is empty!");
		}

		// AjaxResponseBody will be converted into json format and send back to the
		// request.
		return result;

	}

	private boolean isValidSearchCriteria(SearchCriteria search) {

		boolean valid = true;

		if (search == null) {
			valid = false;
		}

		if ((StringUtils.isEmpty(search.getUsername())) || (StringUtils.isEmpty(search.getEmail()))) {
			valid = false;
		}

		return valid;
	}

	// Init some users for testing
	@PostConstruct
	private void iniDataForTesting() {
		users = new ArrayList<User>();

		User user1 = new User("romain", "romppl63@gmail.com");
		User user2 = new User("boss", "boss@yourboss.com");
		users.add(user1);
		users.add(user2);
		userRepository.saveAll(users);
	}

	// Simulate the search function
//	private List<User> findByUserNameOrEmail(String username, String email) {
//
//		List<User> result = new ArrayList<User>();
//
//		for (User user : users) {
//
//			if ((!StringUtils.isEmpty(username)) && (!StringUtils.isEmpty(email))) {
//
//				if (username.equals(user.getUsername()) && email.equals(user.getEmail())) {
//					result.add(user);
//					continue;
//				} else {
//					continue;
//				}
//
//			}
//			if (!StringUtils.isEmpty(username)) {
//				if (username.equals(user.getUsername())) {
//					result.add(user);
//					continue;
//				}
//			}
//
//			if (!StringUtils.isEmpty(email)) {
//				if (email.equals(user.getEmail())) {
//					result.add(user);
//					continue;
//				}
//			}
//
//		}
//
//		return result;
//
//	}
}