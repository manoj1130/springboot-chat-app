package com.chat.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chat.app.dto.MessageRequest;
import com.chat.app.exception.UserNotFoundException;
import com.chat.app.model.Message;
import com.chat.app.model.User;
import com.chat.app.repository.MessageRepository;
import com.chat.app.repository.UserRepository;

@Service
public class MessageService {
	
	@Autowired
	private UserService userService;

	@Autowired
	private MessageRepository messageRepository;
	
	@Autowired
	private UserRepository userRepository;
	
    

    public Message saveMessage(MessageRequest request) {
    	
    	User user = userRepository.findById(request.getUserId())
    			.orElseThrow(()-> new UserNotFoundException(
                        "User not found with id " + request.getUserId()));
    	
    	Message message = new Message();
    	
    	message.setUser(user);
    	message.setContent(request.getContent());
    	message.setTimestamp(request.getTimestamp());
    	
    	return messageRepository.save(message);
    }

    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }
    
    
}