package com.postsystem.demo.web.vo.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
//import com.fasterxml.jackson.databind.PropertyNamingStrategies;
//import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data
//@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserCreationRequestVO {
	
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
