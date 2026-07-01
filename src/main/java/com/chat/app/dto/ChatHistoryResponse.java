package com.chat.app.dto;

import com.chat.app.enums.MessageStatus;

public class ChatHistoryResponse {
	private String sender;
	private String content;
	private String timestamp;
	private MessageStatus status;

	public ChatHistoryResponse() {
	}

	public ChatHistoryResponse(String sender, String content, String timestamp, MessageStatus status) {

		this.sender = sender;
		this.content = content;
		this.timestamp = timestamp;
		this.status = status;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public MessageStatus getStatus() {
	    return status;
	}

	public void setStatus(MessageStatus status) {
	    this.status = status;
	}
}
