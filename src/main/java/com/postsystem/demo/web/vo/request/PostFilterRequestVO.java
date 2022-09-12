package com.postsystem.demo.web.vo.request;


import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.postsystem.demo.core.constant.EngagedPost;

import lombok.Data;

@Data
public class PostFilterRequestVO {

	@JsonProperty("page_size")
	@NotNull
	private Integer pageSize;
	
	@JsonProperty("page_no")
	@NotNull
	private Integer PageNo;
	
	private String search;
    
	@JsonProperty("created_by")
    private Integer createdBy;
    
	@JsonProperty("engaged_post")
	@NotNull
    private EngagedPost engagedPost;
    
	@JsonProperty("date_from")
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:mm:ss")
    private String dateFrom;
    
	@JsonProperty("date_to")
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:mm:ss")
    private String dateTo;
}
