package com.postsystem.demo.web.vo.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import com.postsystem.demo.core.dto.PostCreationDTO;
import com.postsystem.demo.core.dto.PostDTO;
import com.postsystem.demo.core.dto.PostFilterDTO;
import com.postsystem.demo.web.vo.request.PostFilterRequestVO;
import com.postsystem.demo.web.vo.request.PostCreationRequestVO;
import com.postsystem.demo.web.vo.response.PostResponseVO;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PostVOMapper {

	public static final PostVOMapper INSTANCE = Mappers.getMapper(PostVOMapper.class);
	
	PostCreationDTO to(PostCreationRequestVO postRequestVO);
	
	PostResponseVO from(PostDTO postDTO);
	
	PostFilterDTO filterTo(PostFilterRequestVO postFilterRequestVO);
	
	List<PostResponseVO> fromList(List<PostDTO> postDTO);
	
}
