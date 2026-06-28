package com.chat.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chat.app.dto.ChatHistoryResponse;
import com.chat.app.dto.MessageRequest;
import com.chat.app.exception.UserNotFoundException;
import com.chat.app.model.Message;
import com.chat.app.model.User;
import com.chat.app.repository.MessageRepository;
import com.chat.app.repository.UserRepository;

@Service
public class MessageService {
	
	

	@Autowired
	private MessageRepository messageRepository;
	
	@Autowired
	private UserRepository userRepository;
	
    
	// Used by REST API
	public Message saveMessage(MessageRequest request) {

	    User user = userRepository.findById(request.getUserId())
	            .orElseThrow(() -> new UserNotFoundException(
	                    "User not found with id " + request.getUserId()));

	    Message message = new Message();

	    message.setSender(user);
	    message.setReceiver(null);
	    message.setContent(request.getContent());
	    message.setTimestamp(request.getTimestamp());

	    return messageRepository.save(message);
	}

    //Using by WebSocket
	public Message saveMessage(User user, String content) {

	    Message message = new Message();

	    message.setSender(user);
	    message.setReceiver(null);
	    message.setContent(content);
	    message.setTimestamp(java.time.LocalDateTime.now().toString());

	    return messageRepository.save(message);
	}
    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }
    
    public List<ChatHistoryResponse> getChatHistory() {

        return messageRepository.findAll()
                .stream()
                .map(message -> new ChatHistoryResponse(
                        message.getSender().getUsername(),
                        message.getContent(),
                        message.getTimestamp()))
                .collect(Collectors.toList());
    }
    
}