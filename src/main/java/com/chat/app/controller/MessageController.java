package com.chat.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.chat.app.model.Message;
import com.chat.app.service.MessageService;

@RestController
@RequestMapping("/chat")
public class MessageController {

    @Autowired
    private MessageService service;

    @PostMapping("/send")
    public Message sendMessage(@RequestBody Message message) {
        return service.saveMessage(message);
    }

    @GetMapping("/all")
    public List<Message> getMessages() {
        return service.getAllMessages();
    }
}