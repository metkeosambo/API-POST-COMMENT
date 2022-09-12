package com.postsystem.demo.web.vo.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserResponseVO {

private Integer userId;
	
	private String userName;
	
	private String phone;
	
	private String password;
}
