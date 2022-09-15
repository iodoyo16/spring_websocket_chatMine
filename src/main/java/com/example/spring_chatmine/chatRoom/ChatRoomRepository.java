package com.example.spring_chatmine.chatRoom;

import com.example.spring_chatmine.chat.Chat;

public interface ChatRoomRepository {
    void add(ChatRoom chatRoom);
    void remove(String id);
    ChatRoom getChatRoomById(String id);
}
