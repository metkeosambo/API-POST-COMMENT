package com.postsystem.demo.core.service.impl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import com.postsystem.demo.core.dto.FileCreationDTO;
import com.postsystem.demo.core.dto.FileDTO;
import com.postsystem.demo.core.dto.FileListDTO;
import com.postsystem.demo.core.dto.PostFileCreationDTO;
import com.postsystem.demo.core.service.FileService;

public class FileServiceImpl implements FileService {

	private final Path root = Paths.get("uploads");
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		try {
		      Files.createDirectory(root);
		    } catch (IOException e) {
		      throw new RuntimeException("Could not initialize folder for upload!");
		    }
	}

	@Override
	public List<FileDTO> save(FileCreationDTO fileCreationDTO) {
		// TODO Auto-generated method stub
		 try {
			  FileDTO files = new FileDTO();
			  ArrayList<FileDTO> fileArray = new ArrayList<>();
			  fileCreationDTO.getFile().forEach((temp)->{
				  String fileName = RandomStringUtils.random(8, true, true);
				  files.setName(fileName);
				  
				  try {
					  Files.copy(temp.getInputStream(), this.root.resolve(fileName));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}  
			  });  
		      
		    } catch (Exception e) {
		    	
		      throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
		      
		    }
		return null;
	}

	@Override
	public Resource load(String name) {
		try {
		      Path file = root.resolve(name);
		      Resource resource = new UrlResource(file.toUri());
		      if (resource.exists() || resource.isReadable()) {
		        return resource;
		      } else {
		        throw new RuntimeException("Could not read the file!");
		      }
		    } catch (MalformedURLException e) {
		      throw new RuntimeException("Error: " + e.getMessage());
		    }
	}

}
