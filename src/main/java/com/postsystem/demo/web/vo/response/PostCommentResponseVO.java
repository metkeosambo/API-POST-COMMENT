package com.postsystem.demo.web.vo.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PostCommentResponseVO {

	private Integer postCommentId;
	
	private Integer userPostId;
	
	private String cmt;
	
	private Integer parentId;
	
	private Integer createdBy;
	
	private String createdDate;

	private String userName;
}
