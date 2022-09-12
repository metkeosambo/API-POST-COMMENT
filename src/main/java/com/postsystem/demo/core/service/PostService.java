package com.postsystem.demo.core.service;

import java.util.List;

import com.postsystem.demo.core.dto.PostCreationDTO;
import com.postsystem.demo.core.dto.PostDTO;
import com.postsystem.demo.core.dto.PostFilterDTO;

public interface PostService {
	
	PostDTO insert(PostCreationDTO postCreationDTO);
	
	PostDTO getPostByPostId(Integer postId);
	
	List<PostDTO> getAllPost(PostFilterDTO postFilterDTO);
	
	Integer getCountAllPost(PostFilterDTO postFilterDTO);
}
