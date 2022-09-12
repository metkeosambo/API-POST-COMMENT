package com.postsystem.demo.core.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import com.postsystem.demo.core.dto.FileCreationDTO;
import com.postsystem.demo.core.dto.FileDTO;
import org.mapstruct.Mapping;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface FileMapper {

	public static final FileMapper INSTANCE = Mappers.getMapper(FileMapper.class);
	
	@Mapping(target = "name", ignore = true)
	@Mapping(target = "url", ignore = true)
	FileDTO from(FileCreationDTO fileCreationDTO);

}
