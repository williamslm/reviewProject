package com.udacity.jwdnd.c1.review.service;

import com.udacity.jwdnd.c1.review.mapper.ChatMessageMapper;
import com.udacity.jwdnd.c1.review.model.ChatForm;
import com.udacity.jwdnd.c1.review.model.ChatMessage;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {

    private List<ChatMessage> messages;
    private ChatMessageMapper chatMessageMapper;

    public MessageService(ChatMessageMapper chatMessageMapper) {
        this.chatMessageMapper = chatMessageMapper;
    }

    public void addMessage(ChatForm chatForm) {

        ChatMessage newMessage = new ChatMessage();
        newMessage.setUsername(chatForm.getUsername());
        switch (chatForm.getType()) {
            case "say":
                newMessage.setMessagetext(chatForm.getMessage());
                break;
            case "shout":
                newMessage.setMessagetext(chatForm.getMessage().toUpperCase());
                break;
            case "whisper":
                newMessage.setMessagetext(chatForm.getMessage().toLowerCase());
                break;
        }
        chatMessageMapper.insertMessage(newMessage);
    }

    public List<ChatMessage> getMessages() {
        return chatMessageMapper.getAllMessages();
    }

    @PostConstruct
    public void postConstruct() {
        this.messages = new ArrayList<>();
        System.out.println("Creating Message Service - Post Construct");
    }
}
