package com.chat.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chat.app.model.Message;
import com.chat.app.repository.MessageRepository;

@Service
public class MessageService {
	
	@Autowired
	private UserService userService;

	@Autowired
	private MessageRepository messageRepository;
	
    private List<Message> messages = new ArrayList<>();

    public Message saveMessage(Message message) {
    	if(userService.userExists(message.getSender())) {
            return messageRepository.save(message);
    	}
        return null;
    }

    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }
    
    
}