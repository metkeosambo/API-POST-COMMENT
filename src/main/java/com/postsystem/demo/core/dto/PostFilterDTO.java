package com.postsystem.demo.core.dto;


import com.postsystem.demo.core.constant.EngagedPost;

import lombok.Data;

@Data
public class PostFilterDTO {

	private Integer pageSize;
	
	private Integer PageNo;
	
	private String search;
    
    private Integer createdBy;
    
    private EngagedPost engagedPost;
    
    private String dateFrom;
    
    private String dateTo;
}
