package com.springmvc.demo.bo.security;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<User, Long> {

	List<User> findByLastNameAndEmail(String name, String email);
	User findByEmail(String email);
	
}	