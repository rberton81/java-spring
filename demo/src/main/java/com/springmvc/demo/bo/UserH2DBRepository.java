package com.springmvc.demo.bo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserH2DBRepository extends CrudRepository<UserH2DB, Long> {

	List<UserH2DB> findByNameAndEmail(String name, String email);
	
}	