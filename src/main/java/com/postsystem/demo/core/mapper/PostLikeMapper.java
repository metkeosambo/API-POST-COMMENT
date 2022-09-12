package com.postsystem.demo.core.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import com.postsystem.demo.core.dto.PostLikeCreationDTO;
import com.postsystem.demo.core.dto.PostLikeDTO;
import org.mapstruct.Mapping;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PostLikeMapper {
	
	public static final PostLikeMapper INSTANCE = Mappers.getMapper(PostLikeMapper.class);
	
	@Mapping(target = "createdDate", ignore = true)
	@Mapping(target = "postLikeId", ignore = true)
	@Mapping(target = "userName", ignore = true)
	PostLikeDTO from(PostLikeCreationDTO postLikeCreationDTO);
	
	void copy(PostLikeDTO source,@MappingTarget PostLikeDTO target);

}
