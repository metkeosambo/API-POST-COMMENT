package com.postsystem.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.postsystem.demo.core.dto.UserCreationDTO;
import com.postsystem.demo.core.dto.UserDTO;
import com.postsystem.demo.core.service.UserService;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class UserServiceTest {

	@Autowired
	private UserService userService;
	
	@Test
	void resgister() {
		
		UserCreationDTO user = new UserCreationDTO();
		user.setUserName("unittest");
		user.setPhone("012222333");
		user.setPassword("admin");
		
		UserDTO dto = userService.register(user);
		
		assertNotNull(dto);
		log.info("Register User Result: {}", dto);
	}
	
	@Test
	void update() {
		
		UserDTO user = new UserDTO();
		user.setUserId(6);
		user.setUserName("unittest1");
		user.setPhone("012666999");
		user.setPassword("222555");
		
		UserDTO updated = userService.update(user);
		
		assertNotNull(updated);
		log.info("Update User Result: {}", updated);
	}
	
	@Test
	void getUserById() {
		
		UserDTO user = userService.getUserByUserId(6);	
		assertNotNull(user);
		log.info("User Result: {}", user);
	}
	
	@Test
	void login() {
		
		UserDTO user = new UserDTO();
		user.setUserName("unittest1");
		user.setPassword("222555");
		
		boolean login = userService.login(user);
		log.info("User Result: {}", login==true?"login sucess":"login fail");
		
	}
}
	
	


