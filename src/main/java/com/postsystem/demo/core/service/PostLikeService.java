package com.postsystem.demo.core.service;

import java.util.List;

import com.postsystem.demo.core.dto.PostLikeCreationDTO;
import com.postsystem.demo.core.dto.PostLikeDTO;

public interface PostLikeService {

	PostLikeDTO insert(PostLikeCreationDTO postLikeCreationDTO);
	
	Integer delete(Integer postLikeId);
	
	List<PostLikeDTO> getLikeByPostId(Integer userPostId);
}
