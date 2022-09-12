package com.postsystem.demo.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.postsystem.demo.core.dao.PostCommentDAO;
import com.postsystem.demo.core.dto.PostCommentCreationDTO;
import com.postsystem.demo.core.dto.PostCommentDTO;
import com.postsystem.demo.core.mapper.PostCommentMapper;
import com.postsystem.demo.core.service.PostCommentService;


@Service
@Transactional
public class PostCommentServiceImpl implements PostCommentService {

	@Autowired
	private PostCommentDAO postCommentDAO;
	
	@Override
	public PostCommentDTO insert(PostCommentCreationDTO postCommentDTO) {
		
		// TODO Auto-generated method stub
		PostCommentDTO post = PostCommentMapper.INSTANCE.from(postCommentDTO);
				
		postCommentDAO.insert(post);
				
		return post;		
	}

	@Override
	public List<PostCommentDTO> getCommentByPostId(Integer userPostId) {
		
		// TODO Auto-generated method stub
		List<PostCommentDTO> postCommentDTO = postCommentDAO.getCommentByPostId(userPostId);
		
		return postCommentDTO;
	}

}
