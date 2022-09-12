package com.postsystem.demo.web.vo.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import com.postsystem.demo.core.dto.PostLikeCreationDTO;
import com.postsystem.demo.core.dto.PostLikeDTO;
import com.postsystem.demo.web.vo.request.PostLikeRequestCreationVO;
import com.postsystem.demo.web.vo.response.PostLikeResponseVO;


@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PostLikeVOMapper {
	
	public static final PostLikeVOMapper INSTANCE = Mappers.getMapper(PostLikeVOMapper.class);
	
	PostLikeCreationDTO to(PostLikeRequestCreationVO postLikeRequestVO);
	
	PostLikeResponseVO from(PostLikeDTO postLikeDTO);
	
	List<PostLikeResponseVO> fromList(List<PostLikeDTO> postLikeDTO);

}
