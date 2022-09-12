package com.postsystem.demo.web.vo.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class UserRequestVO {

	@JsonProperty("user_id")
	@NotNull
	private Integer userId;
	
	@JsonProperty("username")
	@NotBlank
	private String userName;
	
	@JsonProperty("phone")
	@NotBlank
	@Size(min = 9, max = 10)
	@Pattern(regexp = "^[0-9]*$", message = "Must be a valid number")
	private String phone;
	
	@JsonProperty("password")
	@NotBlank
	private String password;
}
