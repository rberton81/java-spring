package com.springmvc.demo.dto;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
public interface UserRepository extends CrudRepository<UserDTO, Long> {

	List<UserDTO> findByNameAndEmail(String name, String email);
	UserDTO findByName(String name);
	
}	