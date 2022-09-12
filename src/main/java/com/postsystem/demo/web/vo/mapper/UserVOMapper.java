package com.postsystem.demo.web.vo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import com.postsystem.demo.core.dto.UserCreationDTO;
import com.postsystem.demo.core.dto.UserDTO;
import com.postsystem.demo.web.vo.request.UserCreationRequestVO;
import com.postsystem.demo.web.vo.request.UserLoginVO;
import com.postsystem.demo.web.vo.request.UserRequestVO;
import com.postsystem.demo.web.vo.response.UserResponseVO;
import org.mapstruct.Mapping;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)

public interface UserVOMapper {

	public static final UserVOMapper INSTANCE = Mappers.getMapper(UserVOMapper.class);
	
	UserCreationDTO to(UserCreationRequestVO userCreationRequestVO);
	
	UserDTO to(UserRequestVO userRequestVO);
	
	@Mapping(target = "phone", ignore = true)
	@Mapping(target = "userId", ignore = true)
	UserDTO to(UserLoginVO userLoginVO);
	
	UserResponseVO from(UserDTO userDTO);
	
}
