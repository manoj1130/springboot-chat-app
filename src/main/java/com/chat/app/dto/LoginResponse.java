package com.chat.app.dto;

public class LoginResponse {
	private String message;

	public LoginResponse() {
		super();
	}

	public LoginResponse(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
