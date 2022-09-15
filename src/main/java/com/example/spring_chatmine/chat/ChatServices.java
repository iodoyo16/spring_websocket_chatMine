package com.example.spring_chatmine.chat;

import com.example.spring_chatmine.chatRoom.ChatRoom;
import org.springframework.web.socket.WebSocketSession;

public interface ChatServices {
    ChatRoom createRoom();
    <T> void send(WebSocketSession session, Chat chat);
    ChatRoom findRoomById(String id);
}
