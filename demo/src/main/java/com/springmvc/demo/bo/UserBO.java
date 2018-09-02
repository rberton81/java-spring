package com.springmvc.demo.bo;

import com.fasterxml.jackson.annotation.JsonView;
import com.springmvc.demo.bo.Views;

public class UserBO {

	@JsonView(Views.Public.class)
	private String name;

	@JsonView(Views.Public.class)
	private String email;

	@JsonView(Views.Public.class)
	private String role;

	public UserBO() {
		// nothing
	}

	public UserBO(String name, String email) {
		this.name = name;
		this.email = email;
	}

	public UserBO(String name, String password, String email, boolean enabled, String role) {
		this.name = name;
		this.email = email;
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}