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
import com.springmvc.demo.bo.Views;
import com.springmvc.demo.dto.UserDTO;
import com.springmvc.demo.dto.UserRepository;

@RestController
public class AjaxController {
	@Autowired // This means to get the bean called userRepository
	// Which is auto-generated by Spring, we will use it to handle the data
	private UserRepository userRepository;
	private List<UserDTO> users;

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

			UserDTO n = new UserDTO(search.getUsername(), search.getEmail());
			List<UserDTO> usersQuery = userRepository.findByNameAndEmail(n.getName(), n.getEmail());
			if (usersQuery.isEmpty()) {
				UserDTO response = userRepository.save(n);
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

		// AjaxResponseBody will be converted into json format and sent back to the
		// request.
		return result;

	}

	@JsonView(Views.Public.class)
	@RequestMapping(value = "/login/loginSignIn")
	public AjaxResponseBody signIn(@RequestBody SearchCriteria search) {
		AjaxResponseBody result = new AjaxResponseBody();

		// Check if exists before adding
		if (isValidSearchCriteriaSignIn(search)) {

			UserDTO n = new UserDTO(search.getUsername(), "{noop}" + search.getPassword(), search.getEmail(), true, "ROLE_USER");
			
			List<UserDTO> usersQuery = userRepository.findByNameAndEmail(n.getName(), n.getEmail());
			
			if (usersQuery.isEmpty()) {
				UserDTO response = userRepository.save(n);
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


	private boolean isValidSearchCriteriaSignIn(SearchCriteria search) {

		boolean valid = true;

		if (search == null) {
			valid = false;
		}

		if (StringUtils.isEmpty(search.getUsername())
				|| StringUtils.isEmpty(search.getEmail())
						|| StringUtils.isEmpty(search.getPassword()) ) {
			valid = false;
		}

		return valid;
	}
	
	// Init some users for testing
	@PostConstruct
	private void iniDataForTesting() {
		users = new ArrayList<UserDTO>();

		UserDTO user1 = new UserDTO("romain", "{noop}password","romppl63@gmail.com",  false, "RULE_USER");
		UserDTO user2 = new UserDTO("boss", "{noop}password","boss@yourboss.com",  true, "ROLE_ADMIN");
		UserDTO user3 = new UserDTO("user", "{noop}password", "user@pass.com", true,"ROLE_USER");
		users.add(user1);
		users.add(user2);
		users.add(user3);
		userRepository.saveAll(users);
	}
}