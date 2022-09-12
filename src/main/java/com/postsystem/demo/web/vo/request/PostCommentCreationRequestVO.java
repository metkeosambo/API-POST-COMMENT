package com.postsystem.demo.web.vo.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PostCommentCreationRequestVO {

	@JsonProperty("user_post_id")
	@NotNull
	private Integer userPostId;
	
	@NotBlank
	private String cmt;
	
	@JsonProperty("parent_id")
	private Integer parentId;

	@JsonProperty("created_by")
	@NotNull
	private Integer createdBy;

}
