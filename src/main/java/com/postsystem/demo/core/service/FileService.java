package com.postsystem.demo.core.service;


import java.util.List;

import org.springframework.core.io.Resource;

import com.postsystem.demo.core.dto.FileCreationDTO;
import com.postsystem.demo.core.dto.FileDTO;

public interface FileService {

	void init();
	List<FileDTO> save(FileCreationDTO fileCreationDTO);
	Resource load(String name);
}
