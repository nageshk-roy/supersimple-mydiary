package com.nagesh.spring.mydiary.entities;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Entries {

	private int id;
	@DateTimeFormat(pattern="yyyy-mm-dd")
	private Date date;
	private String description;
	private int userid;

	

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
}
