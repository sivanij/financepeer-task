package com.fileupload.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.fileupload.dto.Data;
import com.fileupload.service.FileUploadService;

@RestController
@CrossOrigin
public class FileUploadController {
	
	
	@Autowired
	FileUploadService  fileUploadService;

	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping(value="/upload")
	public List<Data>  uploadUser(@RequestParam("file") MultipartFile file) throws IOException{
		byte[] filedata=file.getBytes();
		List<Data> uploadUser = fileUploadService.UploadUser(filedata);
		
				return uploadUser;
		
	
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping(value="/getData")
	public List<Data>  getData() {

		List<Data> data = fileUploadService.getData();
		return data;


	}

}
