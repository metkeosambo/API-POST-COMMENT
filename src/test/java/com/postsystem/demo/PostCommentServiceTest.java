package com.postsystem.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.postsystem.demo.core.dto.PostCommentCreationDTO;
import com.postsystem.demo.core.dto.PostCommentDTO;
import com.postsystem.demo.core.service.PostCommentService;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class PostCommentServiceTest {

	@Autowired
	private PostCommentService cmt;
	
	@Test
	void createComment() {

		PostCommentCreationDTO postCmt = new PostCommentCreationDTO();
		postCmt.setCmt("Good");
		postCmt.setUserPostId(9);
		postCmt.setCreatedBy(8);
		
		PostCommentDTO save = cmt.insert(postCmt);
		assertNotNull(save);
		log.info("Result Commen {}: ",save);
	}

}
