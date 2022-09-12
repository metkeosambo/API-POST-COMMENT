package com.postsystem.demo.web.util;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseListDataUtils<T>{
	
    private List<T> data;
    private String message;
}
