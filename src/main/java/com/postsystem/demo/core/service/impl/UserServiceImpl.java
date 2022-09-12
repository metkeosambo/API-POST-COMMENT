package com.postsystem.demo.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.postsystem.demo.core.dao.UserDAO;
import com.postsystem.demo.core.dto.UserCreationDTO;
import com.postsystem.demo.core.dto.UserDTO;
import com.postsystem.demo.core.mapper.UserMapper;
import com.postsystem.demo.core.service.UserService;
import com.postsystem.demo.core.util.ObjectUtils;


@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDAO;
	
	@Override
	public UserDTO register(UserCreationDTO userCreationDTO) {
		
		UserDTO userDTO = UserMapper.INSTANCE.from(userCreationDTO);
		
		userDAO.insert(userDTO);
		
		return userDTO;
	}

	@Override
	public UserDTO update(UserDTO userDTO) {
		
		UserDTO user = UserMapper.INSTANCE.from(userDTO);
		
		userDAO.update(user);
		
		return user;
	}

	@Override
	public UserDTO getUserByUserId(Integer userId) {
		// TODO Auto-generated method stub
		UserDTO userDTO = UserMapper.INSTANCE.to(userId);
		
		return userDAO.getUserByUserId(userDTO.getUserId());
	}

	@Override
	public Boolean login(UserDTO userDTO) {
		
		try {
			
			UserDTO user = UserMapper.INSTANCE.from(userDTO);
			UserDTO u = userDAO.login(user);
			
			if(ObjectUtils.isNull(u)) {
				
				return false;
				
			}else {
				
				return true;	
				
			}
			
		}catch(Exception ex) {
			return false;
		} 
	}

}
