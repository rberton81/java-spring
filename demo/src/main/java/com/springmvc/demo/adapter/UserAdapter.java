package com.springmvc.demo.adapter;

import java.util.ArrayList;
import java.util.List;

import com.springmvc.demo.bo.UserBO;
import com.springmvc.demo.dto.UserDTO;

public class UserAdapter {

	public static UserBO userDTOtoBO ( UserDTO userDTO) {
		UserBO userBO = new UserBO();
		userBO.setName(userDTO.getName());
		userBO.setEmail(userDTO.getEmail());
		userBO.setRole(userDTO.getRole());
		return userBO;
	}
	
	public static List<UserBO> usersDTOtoBO ( List<UserDTO> usersDTO) {
		List<UserBO> usersBO = new ArrayList<UserBO>();
		for(UserDTO userDTO : usersDTO) {
			UserBO userBO = userDTOtoBO(userDTO);
			usersBO.add(userBO);
		}
		return usersBO;
	}

	public static List<UserBO> usersDTOtoBO ( Iterable<UserDTO> usersDTO) {
		List<UserBO> usersBO = new ArrayList<UserBO>();
		for(UserDTO userDTO : usersDTO) {
			UserBO userBO = userDTOtoBO(userDTO);
			usersBO.add(userBO);
		}
		return usersBO;
	}
	
}