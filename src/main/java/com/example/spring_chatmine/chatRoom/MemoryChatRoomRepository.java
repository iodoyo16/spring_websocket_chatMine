package com.example.spring_chatmine.chatRoom;

import java.util.LinkedHashMap;
import java.util.Map;

public class MemoryChatRoomRepository implements ChatRoomRepository {
    private Map<String, ChatRoom> memoryChatRoomRepository= new LinkedHashMap<>();

    @Override
    public void add(ChatRoom chatRoom) {
        memoryChatRoomRepository.put(chatRoom.getId(),chatRoom);
    }

    @Override
    public void remove(String id) {
        memoryChatRoomRepository.remove(id);
    }

    @Override
    public ChatRoom getChatRoomById(String id) {
        return memoryChatRoomRepository.get(id);
    }

}
