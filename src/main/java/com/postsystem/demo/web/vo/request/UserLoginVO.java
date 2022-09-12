package com.postsystem.demo.web.vo.request;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class UserLoginVO {

	@JsonProperty("user_name")
	@NotBlank
	private String userName;
	
	@JsonProperty("password")
	@NotBlank
	private String password;
}
