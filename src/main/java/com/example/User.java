package com.example;

public class User {
	private String username;
	private String password;
	//private History history;
	public User() {
		super();
		this.username = null;
		this.password = null;
		//this.history = history;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	 
}
