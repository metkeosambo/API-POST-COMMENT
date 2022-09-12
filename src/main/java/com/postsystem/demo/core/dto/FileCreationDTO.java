package com.postsystem.demo.core.dto;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class FileCreationDTO {
	private List<MultipartFile> file;
}
