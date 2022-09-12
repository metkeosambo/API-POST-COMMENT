package com.postsystem.demo.core.service;

import com.postsystem.demo.core.dto.UserCreationDTO;
import com.postsystem.demo.core.dto.UserDTO;

public interface UserService {
	
	UserDTO register(UserCreationDTO userCreationDTO);
	
	UserDTO update(UserDTO userDTO);
	
	UserDTO getUserByUserId(Integer userId);
	
	Boolean login(UserDTO userDTO);
}
