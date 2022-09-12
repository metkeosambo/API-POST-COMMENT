package com.postsystem.demo.core.dto;

import lombok.Data;

@Data
public class PostCommentDTO {
	
	private Integer postCommentId;
	
	private Integer userPostId;
	
	private String cmt;
	
	private Integer parentId;
	
	private Integer createdBy;
	
	private String createdDate;
	
	private String userName;

}
