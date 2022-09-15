package com.example.spring_chatmine.chatRoom;

import com.example.spring_chatmine.chat.Chat;
import com.example.spring_chatmine.chat.ChatRepository;
import com.example.spring_chatmine.chat.ChatServices;
import org.springframework.web.socket.WebSocketSession;

import java.util.HashSet;
import java.util.Set;

public class ChatRoom {

    private final String id;
    private Set<WebSocketSession> sessions =new HashSet<>();

    public ChatRoom(String id) {
        this.id = id;
    }

    public Set<WebSocketSession> getSessions() {
        return sessions;
    }

    public String getId() {
        return id;
    }
    public void handlerActions(WebSocketSession session, Chat chat, ChatServices chatServices){
        if (chat.getType().equals(Chat.MessageType.ENTER)) {
            sessions.add(session);
            chat.setMessage(chat.getSender() + "님이 입장했습니다.");
        }
        sendMessage(chat, chatServices);
    }
    private <T> void sendMessage(Chat chat, ChatServices chatServices) {
        sessions.parallelStream()
                .forEach(session -> chatServices.send(session, chat));
    }
}
