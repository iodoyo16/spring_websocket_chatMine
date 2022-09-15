package com.example.spring_chatmine.chat;

import com.example.spring_chatmine.chatRoom.ChatRoom;
import com.example.spring_chatmine.chatRoom.ChatRoomRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.UUID;

public class ChatServicesImplement implements ChatServices{
    private ObjectMapper objectMapper;
    private final ChatRepository chatRepository;
    private final ChatRoomRepository chatRoomRepository;


    public ChatServicesImplement(ObjectMapper objectMapper, ChatRepository chatRepository, ChatRoomRepository chatRoomRepository) {
        this.objectMapper = objectMapper;
        this.chatRepository = chatRepository;
        this.chatRoomRepository = chatRoomRepository;
    }

    @Override
    public ChatRoom createRoom() {
        String id = UUID.randomUUID().toString();
        ChatRoom chatRoom= new ChatRoom(id);
        chatRoomRepository.add(chatRoom);
        return chatRoom;
    }

    @Override
    public <T> void send(WebSocketSession session, Chat chat) {
        try{
            session.sendMessage(new TextMessage(objectMapper.writeValueAsString(chat)));
        } catch (IOException e) {
            System.out.println("e = " + e);
        }
    }

    @Override
    public ChatRoom findRoomById(String id) {
        return chatRoomRepository.getChatRoomById(id);
    }
}
