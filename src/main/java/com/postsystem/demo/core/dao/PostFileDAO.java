package com.postsystem.demo.core.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.postsystem.demo.core.dto.PostFileDTO;

@Repository
public interface PostFileDAO {

	Integer insert(PostFileDTO postFileDTO);
	
	List<PostFileDTO> getPostFileByPostId(Integer userPostId);
}
