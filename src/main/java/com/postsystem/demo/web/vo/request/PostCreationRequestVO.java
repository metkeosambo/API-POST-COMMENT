package com.postsystem.demo.web.vo.request;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PostCreationRequestVO {

	@NotBlank
	private String subject;
	
	@NotBlank
	private String description;
	
	@NotNull
	@JsonProperty("created_by")
	private Integer createdBy;
	
	@JsonProperty("post_file")
	@NotEmpty
	private List<PostFileCreationRequestVO> postFile;
}
