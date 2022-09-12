package com.postsystem.demo.core.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.postsystem.demo.core.dto.PostLikeDTO;

@Repository
public interface PostLikeDAO {

	Integer insert(PostLikeDTO postLikeDTO);
	
	Integer delete(Integer postLikeId);
	
	List<PostLikeDTO> getLikeByPostId(Integer userPostId);
}
