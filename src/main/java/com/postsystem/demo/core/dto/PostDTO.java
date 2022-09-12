package com.postsystem.demo.core.dto;

import java.util.List;

import lombok.Data;

@Data
public class PostDTO {

	private Integer userPostId;
	
	private String subject;
	
	private String description;
	
	private String createdDate;
	
	private Integer createdBy;
	
	private String userName;
	
	private String countLike;
	
	private List<PostLikeDTO> like;
	
	private List<PostCommentDTO> cmt;
	
	private List<PostFileDTO> postFile;
	
}
