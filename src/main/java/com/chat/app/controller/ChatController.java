package com.chat.app.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.chat.app.dto.ChatMessage;
import com.chat.app.dto.TypingMessage;
import com.chat.app.repository.UserRepository;
import com.chat.app.service.MessageService;

@Controller
public class ChatController {
	
	@Autowired
	private MessageService messageService;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private SimpMessagingTemplate messagingTemplate;

	@MessageMapping("/send")
	
	public void sendMessage(ChatMessage message, Principal principal) {
		 
		String sender = principal.getName();
		
		message.setSender(sender);
		
		// Save into database
	    messageService.savePrivateMessage(
	            sender,
	            message.getReceiver(),
	            message.getContent()
	    );
	    
		messagingTemplate.convertAndSendToUser(
				message.getReceiver(),
				"/queue/messages",
				message
				);	 
	}
	@MessageMapping("/typing")
	public void typing(TypingMessage typingMessage, Principal principal) {

	    typingMessage.setSender(principal.getName());

	    messagingTemplate.convertAndSendToUser(
	            typingMessage.getReceiver(),
	            "/queue/typing",
	            typingMessage
	    );
	}
}