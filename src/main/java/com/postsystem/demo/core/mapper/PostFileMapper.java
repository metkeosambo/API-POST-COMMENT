package com.postsystem.demo.core.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import com.postsystem.demo.core.dto.PostFileCreationDTO;
import com.postsystem.demo.core.dto.PostFileDTO;
import org.mapstruct.Mapping;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PostFileMapper {

	public static final PostFileMapper INSTANCE = Mappers.getMapper(PostFileMapper.class);

	@Mapping(target = "postFileId", ignore = true)
	PostFileDTO from(PostFileCreationDTO postFileCreationDTO);
	
	void copy(PostFileDTO source,@MappingTarget PostFileDTO target);
}
