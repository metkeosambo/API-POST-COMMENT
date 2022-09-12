package com.postsystem.demo.core.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import com.postsystem.demo.core.dto.PostCreationDTO;
import com.postsystem.demo.core.dto.PostDTO;
import com.postsystem.demo.core.dto.PostFilterDTO;
import org.mapstruct.Mapping;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PostMapper {

	public static final PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);

	@Mapping(target = "cmt", ignore = true)
	@Mapping(target = "countLike", ignore = true)
	@Mapping(target = "createdDate", ignore = true)
	@Mapping(target = "like", ignore = true)
	@Mapping(target = "userName", ignore = true)
	@Mapping(target = "userPostId", ignore = true)
	PostDTO from(PostCreationDTO postCreationDTO);
	
	PostFilterDTO fromFilter(PostFilterDTO postFilterDTO);
	
	List<PostDTO> fromList(List<PostDTO> postDTO);
	
	void copy(PostDTO source, @MappingTarget PostDTO target);	
	
}
