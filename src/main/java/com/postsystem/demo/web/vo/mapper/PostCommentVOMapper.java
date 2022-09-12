package com.postsystem.demo.web.vo.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import com.postsystem.demo.core.dto.PostCommentCreationDTO;
import com.postsystem.demo.core.dto.PostCommentDTO;
import com.postsystem.demo.web.vo.request.PostCommentCreationRequestVO;
import com.postsystem.demo.web.vo.response.PostCommentResponseVO;


@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PostCommentVOMapper {

	public static final PostCommentVOMapper INSTANCE = Mappers.getMapper(PostCommentVOMapper.class);
	
	PostCommentCreationDTO to(PostCommentCreationRequestVO postCommentRequestVO);
	
	PostCommentResponseVO from(PostCommentDTO postCommentDTO);
	
	List<PostCommentResponseVO> fromList(List<PostCommentDTO> postCommentDTO);
	
}
