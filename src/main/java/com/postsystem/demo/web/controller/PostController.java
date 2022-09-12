 package com.postsystem.demo.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.postsystem.demo.core.dto.PostCommentCreationDTO;
import com.postsystem.demo.core.dto.PostCommentDTO;
import com.postsystem.demo.core.dto.PostCreationDTO;
import com.postsystem.demo.core.dto.PostDTO;
import com.postsystem.demo.core.dto.PostFilterDTO;
import com.postsystem.demo.core.dto.PostLikeCreationDTO;
import com.postsystem.demo.core.dto.PostLikeDTO;
import com.postsystem.demo.core.service.PostCommentService;
import com.postsystem.demo.core.service.PostLikeService;
import com.postsystem.demo.core.service.PostService;
import com.postsystem.demo.web.util.ResponseDataUtils;
import com.postsystem.demo.web.util.ResponseHandler;
import com.postsystem.demo.web.util.ResponseListDataUtils;
import com.postsystem.demo.web.util.ResponsePaginationUtils;
import com.postsystem.demo.web.vo.mapper.PostCommentVOMapper;
import com.postsystem.demo.web.vo.mapper.PostLikeVOMapper;
import com.postsystem.demo.web.vo.mapper.PostVOMapper;
import com.postsystem.demo.web.vo.request.PostCommentCreationRequestVO;
import com.postsystem.demo.web.vo.request.PostFilterRequestVO;
import com.postsystem.demo.web.vo.request.PostLikeRequestCreationVO;
import com.postsystem.demo.web.vo.request.PostCreationRequestVO;
import com.postsystem.demo.web.vo.response.PostCommentResponseVO;
import com.postsystem.demo.web.vo.response.PostLikeResponseVO;
import com.postsystem.demo.web.vo.response.PostPaginationResultResponseVO;
import com.postsystem.demo.web.vo.response.PostResponseVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/post")
public class PostController {

	@Autowired
	PostService postService;
	
	@Autowired
	PostLikeService postLikeService;
	
	@Autowired
	PostCommentService postCmtService;
	
	@RequestMapping(value="/create",headers = {
    "content-type=application/json" }, consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public ResponseEntity<ResponseDataUtils<PostResponseVO>> create(@Validated @RequestBody PostCreationRequestVO PostRequestVO) {
		
		try {
			
			log.info("Create Post",PostRequestVO);
			PostCreationDTO postDTO = PostVOMapper.INSTANCE.to(PostRequestVO);
			
			PostDTO create = postService.insert(postDTO);
			
			return ResponseHandler.responseData("success", HttpStatus.CREATED, PostVOMapper.INSTANCE.from(create));
			
		}catch(Exception ex) {
			
			log.error("Post Create error {}:",ex.getMessage());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
		}
	}
	
	@RequestMapping(value="/get/{postId}", method = RequestMethod.GET)
	public ResponseEntity<ResponseDataUtils<PostResponseVO>> getPostByUserId(@PathVariable Integer postId) {
		
		try {
		
			PostDTO get = postService.getPostByPostId(postId);
			
			return ResponseHandler.responseData("success", HttpStatus.OK,PostVOMapper.INSTANCE.from(get));
			
			
		}catch(Exception ex) {
			
			log.error("Get Post By ID Error{}:",ex.getMessage());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
		}
		
	}
	
	@RequestMapping(value="/getall", method = RequestMethod.GET)
	public ResponseEntity<ResponsePaginationUtils<PostResponseVO>> getPostAll(@Validated @RequestBody PostFilterRequestVO postFilterRequestVO) {
		
		try {
			
			PostFilterDTO postFilter = PostVOMapper.INSTANCE.filterTo(postFilterRequestVO);
			
			// Calculate Page offset
			Integer offset = (postFilter.getPageNo()-1) * postFilter.getPageSize();
			
			Integer currentPage = postFilter.getPageNo(); 
			
			postFilter.setPageNo(offset);
			
			List<PostDTO> get = postService.getAllPost(postFilter);
			
			Integer totalItem= postService.getCountAllPost(postFilter);
			
			Integer totalPage = (int) Math.ceil((double)totalItem/postFilter.getPageSize());
			
			PostPaginationResultResponseVO<PostResponseVO> result= new PostPaginationResultResponseVO<>(totalPage,currentPage,totalItem,PostVOMapper.INSTANCE.fromList(get));
			
			return ResponseHandler.responsePagination("success", HttpStatus.OK,result);
			
			
		}catch(Exception ex) {
			
			log.error("Get Post By ID Error{}:",ex.getMessage());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
		}
		
	}
	
	
	//////////////////////// Like //////////////////////
	@RequestMapping(value="/like/create",headers = {
    "content-type=application/json" }, consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public ResponseEntity<ResponseDataUtils<PostLikeResponseVO>> createLike(@Validated @RequestBody PostLikeRequestCreationVO PostLikeRequestVO) {
		
		try {
			
			PostLikeCreationDTO postLikeDTO = PostLikeVOMapper.INSTANCE.to(PostLikeRequestVO);
			
			PostLikeDTO create = postLikeService.insert(postLikeDTO);
			
			return ResponseHandler.responseData("success", HttpStatus.CREATED, PostLikeVOMapper.INSTANCE.from(create));
			
		}catch(Exception ex) {
			
			log.error("Post Like Create error {}:",ex.getMessage());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
		}
	}
	
	@RequestMapping(value="/like/dislike/{postLikeId}",headers = {
    "content-type=application/json" }, consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public ResponseEntity<Object> disLike(@PathVariable Integer postLikeId) {
		
		try {
			
			Integer delete = postLikeService.delete(postLikeId);
			String msg="";
			if(delete==0) {
				msg="fail deleted";
			}else {
				msg="success deleted";
			}
			
			return ResponseHandler.responseWithMsg(msg, HttpStatus.OK);
			
		}catch(Exception ex) {
			
			log.error("Post Like Delete error {}:",ex.getMessage());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
		}
	}
	
	@RequestMapping(value="/like/get/{postId}", method = RequestMethod.GET)
	public ResponseEntity<ResponseListDataUtils<PostLikeResponseVO>> getLikeByUserId(@PathVariable Integer postId) {
		
		try {
		
			List<PostLikeDTO> get = postLikeService.getLikeByPostId(postId);
			
			return ResponseHandler.responseListData("success", HttpStatus.OK,PostLikeVOMapper.INSTANCE.fromList(get));
			
			
		}catch(Exception ex) {
			
			log.error("Get Post Like By ID Error{}:",ex.getMessage());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
		}
		
	}
	
	
	////////////////////////// Comment //////////////////////
	
	@RequestMapping(value="/cmt/create",headers = {
    "content-type=application/json" }, consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public ResponseEntity<ResponseDataUtils<PostCommentResponseVO>> createComment(@Validated @RequestBody PostCommentCreationRequestVO PostCommentRequestVO) {
		
		try {
			
			PostCommentCreationDTO postCommentDTO = PostCommentVOMapper.INSTANCE.to(PostCommentRequestVO);
			
			PostCommentDTO create = postCmtService.insert(postCommentDTO);
			
			return ResponseHandler.responseData("success", HttpStatus.CREATED, PostCommentVOMapper.INSTANCE.from(create));
			
		}catch(Exception ex) {
			
			log.error("Post Like Create error {}:",ex.getMessage());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
		}
	}
	
	@RequestMapping(value="/cmt/get/{postId}", method = RequestMethod.GET)
	public ResponseEntity<ResponseListDataUtils<PostCommentResponseVO>> getCmtByUserId(@PathVariable Integer postId) {
		
		try {
		
			List<PostCommentDTO> get = postCmtService.getCommentByPostId(postId);
			
			return ResponseHandler.responseListData("success", HttpStatus.OK,PostCommentVOMapper.INSTANCE.fromList(get));
			
			
		}catch(Exception ex) {
			
			log.error("Get Post By ID Error{}:",ex.getMessage());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
		}
		
	}
	
	
	
	

}
