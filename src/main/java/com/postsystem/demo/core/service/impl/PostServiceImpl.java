package com.postsystem.demo.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.postsystem.demo.core.dao.PostCommentDAO;
import com.postsystem.demo.core.dao.PostDAO;
import com.postsystem.demo.core.dao.PostFileDAO;
import com.postsystem.demo.core.dao.PostLikeDAO;
import com.postsystem.demo.core.dto.PostCountDTO;
import com.postsystem.demo.core.dto.PostCreationDTO;
import com.postsystem.demo.core.dto.PostDTO;
import com.postsystem.demo.core.dto.PostFileCreationDTO;
import com.postsystem.demo.core.dto.PostFileDTO;
import com.postsystem.demo.core.dto.PostFilterDTO;
import com.postsystem.demo.core.mapper.PostFileMapper;
import com.postsystem.demo.core.mapper.PostMapper;
import com.postsystem.demo.core.service.PostService;


@Service
@Transactional
public class PostServiceImpl implements PostService {


	@Autowired
	private PostFileDAO postFileDAO;
	
	@Autowired
	private PostDAO postDAO;
	
	@Autowired
	private PostLikeDAO postLikeDAO;
	
	@Autowired
	private PostCommentDAO postCmtDAO;
	
	@Override
	public PostDTO insert(PostCreationDTO postDTO) {
		
		// TODO Auto-generated method stub
		PostDTO post = PostMapper.INSTANCE.from(postDTO);
		
		postDAO.insert(post);
		
		post.getPostFile().forEach((temp)->{
			
			PostFileCreationDTO postFileInsert = new PostFileCreationDTO(); 
			postFileInsert.setUserPostId(post.getUserPostId());
			postFileInsert.setFileName(temp.getFileName());
			
			PostFileDTO postFile = PostFileMapper.INSTANCE.from(postFileInsert);
			
			postFileDAO.insert(postFile);
		});
		return post;
	}

	@Override
	public PostDTO getPostByPostId(Integer postId) {
		
		// TODO Auto-generated method stub
		PostDTO postDTO = postDAO.getPostById(postId);
		
		postDTO.setPostFile(postFileDAO.getPostFileByPostId(postId));
		
		postDTO.setLike(postLikeDAO.getLikeByPostId(postId));
		
		postDTO.setCmt(postCmtDAO.getCommentByPostId(postId));
		
		return postDTO;
	}

	@Override
	public List<PostDTO> getAllPost(PostFilterDTO postFilterDTO) {
		
		// TODO Auto-generated method stub
		PostFilterDTO postFilter = PostMapper.INSTANCE.fromFilter(postFilterDTO);
		
		List<PostDTO> post = postDAO.getAllPost(postFilter); 
		
		post.forEach((temp)->{
			
			temp.setPostFile(postFileDAO.getPostFileByPostId(temp.getUserPostId()));
			
			temp.setLike(postLikeDAO.getLikeByPostId(temp.getUserPostId()));
			
			temp.setCmt(postCmtDAO.getCommentByPostId(temp.getUserPostId()));
			
		});
		
		return post;
	}

	@Override
	public Integer getCountAllPost(PostFilterDTO postFilterDTO) {
		// TODO Auto-generated method stub
		PostFilterDTO postFilter = PostMapper.INSTANCE.fromFilter(postFilterDTO);
		
		PostCountDTO result = postDAO.getCountAllPost(postFilter);
		
		System.out.println(result);
		
		return result.getCount();
	}

}
