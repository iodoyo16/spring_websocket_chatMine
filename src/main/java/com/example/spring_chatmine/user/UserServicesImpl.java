package com.example.spring_chatmine.user;

public class UserServicesImpl implements UserServices{

    private final UserRepository userRepository;

    public UserServicesImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void register(User user) {
        userRepository.register(user);

    }

    @Override
    public void unregister(User user) {
        userRepository.unregister(user);
    }


    @Override
    public User findUser(String id) {
        return userRepository.findById(id);
    }
}
