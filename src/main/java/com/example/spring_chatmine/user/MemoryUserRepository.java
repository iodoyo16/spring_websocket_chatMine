package com.example.spring_chatmine.user;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MemoryUserRepository implements UserRepository{

    private static Map<String, User> userRepo= new ConcurrentHashMap<>();
    @Override
    public void register(User user) {
        userRepo.put(user.getId(),user);
    }

    @Override
    public void unregister(User user) {
        userRepo.remove(user.getId());
    }

    @Override
    public User findById(String id) {
        return userRepo.get(id);
    }
}
