package com.example.spring_chatmine.chat;

public interface ChatRepository {
    void add(Chat chat);
    void remove(Long id);
    Chat getChatById(Long id);
    Chat getChatsBySenderId(String id);
    Chat getChatsByRoomId(Long id);
    Chat getChatsByMsg(String msg);
}
