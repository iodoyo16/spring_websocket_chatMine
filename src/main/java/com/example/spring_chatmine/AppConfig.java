package com.example.spring_chatmine;

import com.example.spring_chatmine.chat.ChatRepository;
import com.example.spring_chatmine.chat.ChatServices;
import com.example.spring_chatmine.chat.ChatServicesImplement;
import com.example.spring_chatmine.chat.MemoryChatRepository;
import com.example.spring_chatmine.chatRoom.ChatRoomRepository;
import com.example.spring_chatmine.chatRoom.MemoryChatRoomRepository;
import com.example.spring_chatmine.user.MemoryUserRepository;
import com.example.spring_chatmine.user.UserRepository;
import com.example.spring_chatmine.user.UserServices;
import com.example.spring_chatmine.user.UserServicesImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public UserRepository userRepository(){
        return new MemoryUserRepository();
    }
    @Bean
    public UserServices userServices(){
        return new UserServicesImpl(userRepository());
    }
    @Bean
    public ChatRepository chatRepository(){
        return new MemoryChatRepository();
    }
    @Bean
    public ChatRoomRepository chatRoomRepository(){return new MemoryChatRoomRepository();}
    @Bean
    public ChatServices chatServices(){ return new ChatServicesImplement(new ObjectMapper(),chatRepository(),chatRoomRepository());}
}
