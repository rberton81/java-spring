package com.springmvc.demo.bo.security;

import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface PrivilegeRepository extends CrudRepository<Privilege, Long> {

	Privilege findByName(String name);
	
}	