package com.springmvc.demo.bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonView;

@Entity // This tells Hibernate to make a table out of this class
public class UserH2DB {
	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

	@JsonView(Views.Public.class)
    private String name;

    private String password;
	
	@JsonView(Views.Public.class)
    private String email;

	public UserH2DB() {
		// nothing
	}
	
	public UserH2DB(String name, String email) {
		this.name = name;
		this.email = email;
	}

	public UserH2DB(String name, String password, String email) {
		this.name = name;
		this.password = password;
		this.email = email;
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


}