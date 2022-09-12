package com.postsystem.demo.core.service;

import java.util.List;

import com.postsystem.demo.core.dto.PostCommentCreationDTO;
import com.postsystem.demo.core.dto.PostCommentDTO;

public interface PostCommentService {

	PostCommentDTO insert(PostCommentCreationDTO postCommentCreationDTO);
	
	List<PostCommentDTO> getCommentByPostId(Integer userPostId);
}
