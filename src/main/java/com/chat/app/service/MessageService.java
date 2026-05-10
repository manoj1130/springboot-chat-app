package com.chat.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chat.app.model.Message;

@Service
public class MessageService {
	
	@Autowired
	private UserService userService;

    private List<Message> messages = new ArrayList<>();

    public Message saveMessage(Message message) {
    	if(userService.userExists(message.getSender())) {
    		messages.add(message);
            return message;
    	}
        return null;
    }

    public List<Message> getAllMessages() {
        return messages;
    }
    
    
}