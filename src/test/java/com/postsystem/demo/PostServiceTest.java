package com.postsystem.demo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.postsystem.demo.core.dto.PostCreationDTO;
import com.postsystem.demo.core.dto.PostDTO;
import com.postsystem.demo.core.dto.PostFileCreationDTO;
import com.postsystem.demo.core.service.PostService;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class PostServiceTest {

	@Autowired
	private PostService postService;
	
	
	@Test
	void Post() {
		
		PostCreationDTO post = new PostCreationDTO();
		post.setSubject("Happy Holiday");
		post.setDescription("Today I'm so happy to create Unit test");
		post.setCreatedBy(6);
		
		PostFileCreationDTO file = new PostFileCreationDTO();
		file.setFileName("unittest.jpg");
		
		PostFileCreationDTO file1 = new PostFileCreationDTO();
		file.setFileName("unittest1.jpg");
		
		ArrayList<PostFileCreationDTO> fileSave = new ArrayList<>();
		fileSave.add(file);
		fileSave.add(file1);
		
		post.setPostFile(fileSave);
		PostDTO save = postService.insert(post);
		
		assertNotNull(save);
		log.info("Result Post Create {}: " ,save);

	}
	
	@Test
	void getPostById() {
		
		PostDTO post = postService.getPostByPostId(9);
		assertNotNull(post);
		log.info("Result Post {}: " ,post);
	}

}
