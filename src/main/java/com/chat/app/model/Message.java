package com.chat.app.model;

public class Message {
	    private String sender;
	    private String content;
	    private String timestamp;
		public Message(String sender, String content, String timestamp) {
			super();
			this.sender = sender;
			this.content = content;
			this.timestamp = timestamp;
		}
		public Message() {
			super();
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
	    
}
