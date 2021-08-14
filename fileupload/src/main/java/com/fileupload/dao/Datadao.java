package com.fileupload.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Component
@JsonIgnoreProperties(ignoreUnknown=true)
@Table(name="UserData")
@Entity
public class Datadao {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

	private Integer id;
	private Integer userId;
	
//	private Integer id;
	
	private String title ;
	
	private String body ;

//	public Long getBusinessKey() {
//		return BusinessKey;
//	}

//	public void setBusinessKey(Long businessKey) {
//		BusinessKey = businessKey;
//	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
	
	}
