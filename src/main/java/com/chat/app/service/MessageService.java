package com.chat.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.chat.app.model.Message;

@Service
public class MessageService {

    private List<Message> messages = new ArrayList<>();

    public Message saveMessage(Message message) {
        messages.add(message);
        return message;
    }

    public List<Message> getAllMessages() {
        return messages;
    }
}