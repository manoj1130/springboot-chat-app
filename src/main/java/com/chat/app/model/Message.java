package com.chat.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "messages")
public class Message {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
	    private String sender;
	    private String content;
	    private String timestamp;
		public Message(Long id, String sender, String content, String timestamp) {
			super();
			this.id = id;
			this.sender = sender;
			this.content = content;
			this.timestamp = timestamp;
		}
		public Message() {
			super();
		}
		
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
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
