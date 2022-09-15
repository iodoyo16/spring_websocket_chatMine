package com.example.spring_chatmine.user;

public interface UserServices {
    void register(User user);
    void unregister(User user);
    User findUser(String id);
}
