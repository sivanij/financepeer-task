package com.fileupload.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fileupload.dao.Datadao;
import com.fileupload.dto.Data;
import com.fileupload.exception.NoDataFoundException;
import com.fileupload.repository.DataRepository;
import com.fileupload.service.FileUploadService;

@Service
public class FieUploadServiceImpl implements FileUploadService {
	@Autowired
	DataRepository userRepository;


	@Override
	public List<Data> UploadUser(byte[] filedata) throws JsonMappingException, JsonProcessingException  {

		JSONArray jsonArray = new JSONArray(new String(filedata));
		ObjectMapper mapper = new ObjectMapper();
		List<Data> participantJsonList = mapper.readValue(jsonArray.toString(), new TypeReference<List<Data>>(){});
		List<Datadao> convertdtotodao = convertdtotodao(participantJsonList);
		userRepository.saveAll(convertdtotodao);

		return participantJsonList;
	}

	private List<Datadao> convertdtotodao(List<Data> participantJsonList) {
		List<Datadao> datacoll= new ArrayList<Datadao>();
		for (Data data : participantJsonList) {
			Datadao datadao = new Datadao();

			if(null!=data.getBody()) {
				datadao.setBody(data.getBody());

			}
			if(null!=data.getId()) {
				datadao.setId(data.getId());

			}
			if(null!=data.getTitle()) {
				datadao.setTitle(data.getTitle());

			}
			if(null!=data.getUserId()) {
				datadao.setUserId(data.getUserId());
			}

			datacoll.add(datadao);
		}
		return datacoll;
	}

	@Override
	public List<Data> getData() {
		List<Datadao> findAll = userRepository.findAll();
//		if(findAll.size()>0) {
			List<Data> convertdaotodto = convertdaotodto(findAll);
			return convertdaotodto;
//		}

//		else {
//			throw new NoDataFoundException();
//
//		}
	}




	private List<Data> convertdaotodto(List<Datadao> findAll) {
		List<Data> datacoll= new ArrayList<Data>();
		for (Datadao datadao : findAll) {
			Data data = new Data();

			if(null!=datadao.getBody()) {
				data.setBody(datadao.getBody());

			}
			if(null!=datadao.getId()) {
				data.setId(datadao.getId());

			}
			if(null!=datadao.getTitle()) {
				data.setTitle(datadao.getTitle());

			}
			if(null!=datadao.getUserId()) {
				data.setUserId(datadao.getUserId());
			}

			datacoll.add(data);
		}
		return datacoll;
	}

}
