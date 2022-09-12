package com.postsystem.demo.core.dao;

import org.springframework.stereotype.Repository;

import com.postsystem.demo.core.dto.UserDTO;

@Repository
public interface UserDAO {
	
	Integer insert(UserDTO userDTO);
	
	Integer update(UserDTO userDTO);
	
	UserDTO getUserByUserId(Integer userId);
	
	UserDTO login(UserDTO userDTO);
		
}
