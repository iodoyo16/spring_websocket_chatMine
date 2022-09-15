package com.example.spring_chatmine.WebSocket;

import com.example.spring_chatmine.chat.Chat;
import com.example.spring_chatmine.chatRoom.ChatRoom;
import com.example.spring_chatmine.chat.ChatServices;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class WebSocketHandler extends TextWebSocketHandler {
    private final ObjectMapper objectMapper;
    private final ChatServices chatServices;

    public WebSocketHandler(ObjectMapper objectMapper, ChatServices chatServices) {
        this.objectMapper = objectMapper;
        this.chatServices = chatServices;
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();
        System.out.println("payload = " + payload);
        Chat receivedChat=objectMapper.readValue(payload,Chat.class);
        System.out.println("receivedChat = " + receivedChat.getRoomId());
        ChatRoom chatRoom=chatServices.findRoomById(receivedChat.getRoomId());
        System.out.println("chatRoom.toString() = " + chatRoom.toString());
        chatRoom.handlerActions(session,receivedChat,chatServices);
    }
}