package com.postsystem.demo.core.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.postsystem.demo.core.dto.PostCommentDTO;

@Repository
public interface PostCommentDAO {

	Integer insert(PostCommentDTO postCommentDTO);
	
	List<PostCommentDTO> getCommentByPostId(Integer userPostId);
}
