package com.postsystem.demo.web.vo.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PostFileResponseVO {

	private Integer postFileId;
	
	private Integer userPostId;
	
	private String fileName;
}
