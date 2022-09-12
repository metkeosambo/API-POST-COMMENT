package com.postsystem.demo.core.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.postsystem.demo.core.dto.UserCreationDTO;
import com.postsystem.demo.core.dto.UserDTO;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper {
	
	public static final UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
	
	@Mapping(target = "userId", ignore = true)
	UserDTO from(UserCreationDTO userCreationDTO);
	
	UserDTO from(UserDTO UserDTO);
	
	@Mapping(target = "password", ignore = true)
	@Mapping(target = "phone", ignore = true)
	@Mapping(target = "userName", ignore = true)
	UserDTO to(Integer userId);
	
	void copy(UserDTO source, @MappingTarget UserDTO target);	
	
}
