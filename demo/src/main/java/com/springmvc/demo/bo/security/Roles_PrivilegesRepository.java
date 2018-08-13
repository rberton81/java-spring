package com.springmvc.demo.bo.security;


import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface Roles_PrivilegesRepository extends CrudRepository<Roles_Privileges, Long> {

}	