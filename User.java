package com.nagesh.spring.mydiary.entities;

public class User {

	
	private int userId;
	private String username;
	private String paswwd;
	
	public User(int empid, String username, String paswwd) {
		this.userId=empid;
		this.username=username;
		this.paswwd=paswwd;
	}
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPaswwd() {
		return paswwd;
	}
	public void setPaswwd(String paswwd) {
		this.paswwd = paswwd;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
}
