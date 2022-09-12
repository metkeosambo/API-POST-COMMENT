package com.postsystem.demo.web.vo.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PostLikeResponseVO {

	private Integer postLikeId;
	
	private Integer userPostId;
	
	private Integer createdBy;
	
	private String createdDate;

	private String userName;
}
