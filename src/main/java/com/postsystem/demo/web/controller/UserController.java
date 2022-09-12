package com.postsystem.demo.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.postsystem.demo.core.dto.UserCreationDTO;
import com.postsystem.demo.core.dto.UserDTO;
import com.postsystem.demo.core.service.UserService;
import com.postsystem.demo.web.util.ResponseDataUtils;
import com.postsystem.demo.web.util.ResponseHandler;
import com.postsystem.demo.web.vo.mapper.UserVOMapper;
import com.postsystem.demo.web.vo.request.UserCreationRequestVO;
import com.postsystem.demo.web.vo.request.UserLoginVO;
import com.postsystem.demo.web.vo.request.UserRequestVO;
import com.postsystem.demo.web.vo.response.*;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/register",headers = {
    "content-type=application/json" }, consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public ResponseEntity<ResponseDataUtils<UserResponseVO>> register(@Validated @RequestBody UserCreationRequestVO userCreationRequestVO) {
		
		try {
			
			UserCreationDTO userCreationDTO = UserVOMapper.INSTANCE.to(userCreationRequestVO);
			
			UserDTO register = userService.register(userCreationDTO);
			
			return ResponseHandler.responseData("success", HttpStatus.CREATED, UserVOMapper.INSTANCE.from(register));
			
		}catch(Exception ex) {
			
			log.error("User Create error {}:",ex.getMessage());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
		}
	}
	
	@RequestMapping(value="/update",headers = {
    "content-type=application/json" }, consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public ResponseEntity<ResponseDataUtils<UserResponseVO>> update(@Validated @RequestBody UserRequestVO userRequestVO) {
		
		try {
			
			UserDTO userDTO = UserVOMapper.INSTANCE.to(userRequestVO);
			
			UserDTO update = userService.update(userDTO);
			
			
			return ResponseHandler.responseData("success", HttpStatus.OK, UserVOMapper.INSTANCE.from(update));
			
		}catch(Exception ex) {
			
			log.error("Update User Error{}: ",ex.getMessage());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
		}
	}
	
	@RequestMapping(value="/get/{userId}", method = RequestMethod.GET)
	public ResponseEntity<ResponseDataUtils<UserResponseVO>> getUserByUserId(@PathVariable Integer userId) {
		
		try {
		
			UserDTO getUser = userService.getUserByUserId(userId);
			
			return ResponseHandler.responseData("success", HttpStatus.OK,UserVOMapper.INSTANCE.from(getUser));
			
			
		}catch(Exception ex) {
			
			log.error("Get User By ID Error{}:",ex.getMessage());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
		}
		
	}
	
	@RequestMapping(value="/login",headers = {
    "content-type=application/json" }, consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public ResponseEntity<Object> login(@Validated @RequestBody UserLoginVO userLoginVO) {
		
		try {
			
			UserDTO userDTO = UserVOMapper.INSTANCE.to(userLoginVO);
			
			Boolean result = userService.login(userDTO);
			if(result) {
				
				return ResponseHandler.responseWithMsg("Login Success", HttpStatus.OK);
				
			}else {
				
				return ResponseHandler.responseWithMsg("Invalid Username or Password",HttpStatus.BAD_REQUEST);
				
			}
			
		}catch(Exception ex) {
			
			log.error("Login Error {}: ",ex.getMessage());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
		}
	}
	
	
}
