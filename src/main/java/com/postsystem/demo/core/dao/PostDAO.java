package com.postsystem.demo.core.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.postsystem.demo.core.dto.PostCountDTO;
import com.postsystem.demo.core.dto.PostDTO;
import com.postsystem.demo.core.dto.PostFilterDTO;


@Repository
public interface PostDAO {
	
	Integer insert(PostDTO postDTO);
	
	PostDTO getPostById(Integer id);
	
	List<PostDTO> getAllPost(PostFilterDTO postFilterDTO);
	
	PostCountDTO getCountAllPost(PostFilterDTO postFilterDTO);
}
