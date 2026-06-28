package com.chat.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.chat.app.dto.ChatHistoryResponse;
import com.chat.app.dto.MessageRequest;
import com.chat.app.model.Message;
import com.chat.app.service.MessageService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping("/send")
    public ResponseEntity<?> sendMessage(@Valid @RequestBody MessageRequest request) {
    	
        Message saved = messageService.saveMessage(request);
        if(saved == null) {
        	return ResponseEntity.badRequest().body("User not found. Join first");
        }
        return ResponseEntity.ok(saved);
    }

    
    @GetMapping("/all")
    public ResponseEntity<List<Message>> getMessages() {

        List<Message> messages = messageService.getAllMessages();

        return ResponseEntity.ok(messages);
    }
    
    @GetMapping("/history")
    public List<ChatHistoryResponse> getChatHistory(){
    	return messageService.getChatHistory();
    }
    
    
}