package com.example.spring_chatmine.chat;

import com.example.spring_chatmine.chatRoom.ChatRoom;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/chat")
public class ChatController {
    private final ChatServices chatServices;

    public ChatController(ChatServices chatServices) {
        this.chatServices = chatServices;
    }
    @PostMapping
    public ChatRoom createRoom(){
        return chatServices.createRoom();
    }
}
