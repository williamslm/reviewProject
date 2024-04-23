package com.udacity.jwdnd.c1.review.controller;

import com.udacity.jwdnd.c1.review.model.ChatForm;
import com.udacity.jwdnd.c1.review.service.MessageService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ChatController {
    MessageService messageService;

    public ChatController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/chat")
    public String chat(Authentication authentication, Model model, ChatForm chatForm){

        chatForm.setUsername(authentication.getName());
        messageService.addMessage(chatForm);
        chatForm.setMessage("");
        model.addAttribute("messages", messageService.getMessages());
        return "chat";
    }

    @GetMapping("/chat")
    public String display(@ModelAttribute("chatForm") ChatForm chatForm, Model model){
        model.addAttribute("messages", messageService.getMessages());
        return "chat";
    }

    @ModelAttribute("allMessageTypes")
    public String[] allMessageTypes () {
        return new String[] { "Say", "Shout", "Whisper" };
    }
}
