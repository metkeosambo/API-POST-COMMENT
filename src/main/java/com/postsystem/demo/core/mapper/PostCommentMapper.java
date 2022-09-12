package com.postsystem.demo.core.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import com.postsystem.demo.core.dto.PostCommentCreationDTO;
import com.postsystem.demo.core.dto.PostCommentDTO;
import org.mapstruct.Mapping;


@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PostCommentMapper {

	public static final PostCommentMapper INSTANCE = Mappers.getMapper(PostCommentMapper.class);
	
	@Mapping(target = "createdDate", ignore = true)
	@Mapping(target = "postCommentId", ignore = true)
	@Mapping(target = "userName", ignore = true)
	PostCommentDTO from(PostCommentCreationDTO postCommentCreationDTO);
	
	void copy(PostCommentDTO source,@MappingTarget PostCommentDTO target);
}
