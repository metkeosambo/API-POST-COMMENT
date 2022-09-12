package com.postsystem.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.postsystem.demo.core.dto.PostLikeCreationDTO;
import com.postsystem.demo.core.dto.PostLikeDTO;
import com.postsystem.demo.core.service.PostLikeService;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class PostLikeServiceTest {

	@Autowired
	private PostLikeService postLikeService;
	
	@Test
	void createLike() {
		
		PostLikeCreationDTO like = new PostLikeCreationDTO();
		like.setUserPostId(9);
		like.setCreatedBy(9);
		
		PostLikeDTO save = postLikeService.insert(like);
		assertNotNull(save);
		log.info("Result like {}: ",save);
	}

}
