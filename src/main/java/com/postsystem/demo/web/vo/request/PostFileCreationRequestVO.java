package com.postsystem.demo.web.vo.request;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class PostFileCreationRequestVO {
	
	@JsonProperty("file_name")
	@NotBlank
	private String fileName;
	
}
