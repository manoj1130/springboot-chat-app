package com.chat.app.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.chat.app.dto.ChatMessage;
import com.chat.app.model.User;
import com.chat.app.repository.UserRepository;
import com.chat.app.service.MessageService;

@Controller
public class ChatController {
	
	@Autowired
	private MessageService messageService;

	@Autowired
	private UserRepository userRepository;

	@MessageMapping("/send")
	@SendTo("/topic/messages")
	public ChatMessage sendMessage(ChatMessage message, Principal principal) {
		String username = principal.getName();
		User user = userRepository.findByUsername(username)
					.orElseThrow(()-> new RuntimeException("User not found"));
		messageService.saveMessage(user,message.getContent());
		message.setSender(username);
		return message;
	}
}