package com.chat.app.model;

public class User {
	private long id;
	private String name;
	
	User(){
		
	}
	User(long id, String name){
		this.id = id;
		this.name = name;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
