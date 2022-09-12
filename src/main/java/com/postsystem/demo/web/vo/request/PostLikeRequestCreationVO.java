package com.postsystem.demo.web.vo.request;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class PostLikeRequestCreationVO {

	@JsonProperty("user_post_id")
	@NotNull
	private Integer userPostId;
	
	@JsonProperty("created_by")
	@NotNull
	private Integer createdBy;
	
}
