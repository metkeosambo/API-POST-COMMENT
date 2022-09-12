package com.postsystem.demo.core.dto;

import lombok.Data;

@Data
public class PostCommentCreationDTO {

	private Integer userPostId;
	
	private String cmt;
	
	private Integer parentId;
	
	private Integer createdBy;
}
