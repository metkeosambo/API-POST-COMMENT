package com.postsystem.demo.web.vo.response;

import java.util.List;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.postsystem.demo.core.dto.PostCommentDTO;
import com.postsystem.demo.core.dto.PostLikeDTO;

import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PostResponseVO {

	private Integer userPostId;
	
	private String subject;
	
	private String description;
	
	private String createdDate;
	
	private Integer createdBy;

	private String userName;
	
	private String countLike;
	
	private List<PostLikeDTO> like;
	
	private List<PostCommentDTO> cmt;
	
	private List<PostFileResponseVO> postFile;
	
}
