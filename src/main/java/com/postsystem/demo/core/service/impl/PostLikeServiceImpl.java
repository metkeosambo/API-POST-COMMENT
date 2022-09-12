package com.postsystem.demo.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.postsystem.demo.core.dao.PostLikeDAO;
import com.postsystem.demo.core.dto.PostLikeCreationDTO;
import com.postsystem.demo.core.dto.PostLikeDTO;
import com.postsystem.demo.core.mapper.PostLikeMapper;
import com.postsystem.demo.core.service.PostLikeService;


@Service
@Transactional
public class PostLikeServiceImpl implements PostLikeService {
	
	@Autowired
	private PostLikeDAO postLikeDAO;

	@Override
	public PostLikeDTO insert(PostLikeCreationDTO postLikeDTO) {
		
		// TODO Auto-generated method stub
		PostLikeDTO post = PostLikeMapper.INSTANCE.from(postLikeDTO);
		
		postLikeDAO.insert(post);
		
		return post;
	}

	@Override
	public Integer delete(Integer postLikeId) {
		
		// TODO Auto-generated method stub		
		Integer delete =postLikeDAO.delete(postLikeId);
		
		return delete;
	}

	@Override
	public List<PostLikeDTO> getLikeByPostId(Integer userPostId) {
		
		// TODO Auto-generated method stub
		List<PostLikeDTO> postLikeDTO = postLikeDAO.getLikeByPostId(userPostId);
		
		return postLikeDTO;
	}

}
