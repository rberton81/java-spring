package com.springmvc.demo.bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "USERS")
public class User {
	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

	@JsonView(Views.Public.class)
    private String name;

    private String password;

	@JsonView(Views.Public.class)
    private String email;
	
    private boolean enabled;

    private String role;

	public User() {
		// nothing
	}
	
	public User(String name, String email) {
		this.name = name;
		this.email = email;
	}
	

	public User(String name, String password, String email, boolean enabled, String role) {
		this.name = name;
		this.password = password;
		this.email = email;
		this.enabled = enabled;
		this.role = role;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}


}