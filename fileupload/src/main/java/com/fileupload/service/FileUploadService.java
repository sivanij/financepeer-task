package com.fileupload.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fileupload.dto.Data;

@Service
public interface FileUploadService {
	
	public List<Data> UploadUser(byte[] filedata) throws JsonMappingException, JsonProcessingException ;

	List<Data> getData();
}
