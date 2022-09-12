package com.postsystem.demo.web.vo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import com.postsystem.demo.core.dto.PostFileCreationDTO;
import com.postsystem.demo.core.dto.PostFileDTO;
import com.postsystem.demo.web.vo.request.PostFileCreationRequestVO;
import com.postsystem.demo.web.vo.response.PostFileResponseVO;
import org.mapstruct.Mapping;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PostFileVOMapper {

	public static final PostFileVOMapper INSTANCE = Mappers.getMapper(PostFileVOMapper.class);
	
	@Mapping(target = "userPostId", ignore = true)
	PostFileCreationDTO to(PostFileCreationRequestVO postFileRequestVO);
	
	PostFileResponseVO from(PostFileDTO postFileDTO);
	
}
