package com.postsystem.demo.core.dto;

import java.util.List;

import lombok.Data;
@Data
public class PostCreationDTO {

	private String subject;
	
	private String description;
		
	private Integer createdBy;
	
	private List<PostFileCreationDTO> postFile;
}
