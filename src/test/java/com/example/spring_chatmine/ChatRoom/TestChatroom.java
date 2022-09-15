package com.example.spring_chatmine.ChatRoom;

import com.example.spring_chatmine.chatRoom.ChatRoom;
import com.example.spring_chatmine.chatRoom.ChatRoomRepository;
import com.example.spring_chatmine.chatRoom.MemoryChatRoomRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestChatroom {
    ChatRoomRepository chatRoomRepository = new MemoryChatRoomRepository();
    @Test
    void add(){
        ChatRoom chatRoom=new ChatRoom("e2ba1574-a47d-438d-8551-ff7107970e0e");
        chatRoomRepository.add(chatRoom);
        ChatRoom chatRoomById = chatRoomRepository.getChatRoomById("e2ba1574-a47d-438d-8551-ff7107970e0e");
        Assertions.assertThat(chatRoom).isEqualTo(chatRoomById);
        System.out.println("chatRoom = " + chatRoom);
        System.out.println("chatRoomById = " + chatRoomById);
    }
}
