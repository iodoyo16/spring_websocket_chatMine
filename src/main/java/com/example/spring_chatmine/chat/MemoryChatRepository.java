package com.example.spring_chatmine.chat;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MemoryChatRepository implements ChatRepository{

    private static Map<Long, Chat> memoryChatRepository= new ConcurrentHashMap<>();

    @Override
    public void add(Chat chat) {
        memoryChatRepository.put(chat.getId(),chat);
    }

    @Override
    public void remove(Long id) {
        memoryChatRepository.remove(id);
    }

    @Override
    public Chat getChatById(Long id) {
        return memoryChatRepository.get(id);
    }

    @Override
    public Chat getChatsBySenderId(String id) {
        return null;
    }

    @Override
    public Chat getChatsByRoomId(Long id) {
        return null;
    }

    @Override
    public Chat getChatsByMsg(String msg) {
        return null;
    }
}
