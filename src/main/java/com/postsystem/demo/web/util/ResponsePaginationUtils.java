package com.postsystem.demo.web.util;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@AllArgsConstructor
@NoArgsConstructor
public class ResponsePaginationUtils<T> {

	private Integer totalPage;
	
	private Integer currentPage;
	
	private Integer totalItems;
	
    private List<T> data;
    
    private String message;
	
}
