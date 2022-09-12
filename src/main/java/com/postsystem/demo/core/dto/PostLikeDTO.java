package com.postsystem.demo.core.dto;

import lombok.Data;

@Data
public class PostLikeDTO {

	private Integer postLikeId;
	
	private Integer userPostId;
	
	private Integer createdBy;
	
	private String createdDate;

	private String userName;
	
}
