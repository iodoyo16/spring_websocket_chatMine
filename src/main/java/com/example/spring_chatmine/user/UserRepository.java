package com.example.spring_chatmine.user;

public interface UserRepository {
    void register(User user);

    void unregister(User user);
    User findById(String id);
}
