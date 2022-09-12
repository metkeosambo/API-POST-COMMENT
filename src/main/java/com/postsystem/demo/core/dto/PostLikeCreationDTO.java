package com.postsystem.demo.core.dto;

import lombok.Data;

@Data
public class PostLikeCreationDTO {

	private Integer userPostId;
	
	private Integer createdBy;
}
