package com.chat.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.chat.app.model.Message;
import com.chat.app.service.MessageService;

@RestController
@RequestMapping("/chat")
public class MessageController {

    @Autowired
    private MessageService service;

    @PostMapping("/send")
    public ResponseEntity<?> sendMessage(@RequestBody Message message) {
    	
        Message saved = service.saveMessage(message);
        if(saved == null) {
        	return ResponseEntity.badRequest().body("User not found. Join first");
        }
        return ResponseEntity.ok(saved);
    }

    
    @GetMapping("/all")
    public ResponseEntity<List<Message>> getMessages() {

        List<Message> messages = service.getAllMessages();

        return ResponseEntity.ok(messages);
    }
    
    
}