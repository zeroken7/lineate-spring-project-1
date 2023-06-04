package com.example.lineatespring.services;

import com.example.lineatespring.models.User;
import com.example.lineatespring.repositories.UserRepository;

import java.util.List;

public class UserService {

    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAll() {
        return userRepository.getAllUsers();
    }

    public void addUser(User user) {
        userRepository.addUser(user);
    }

    public void addDummyData() {
        addUser(new User(18321, "alice"));
        addUser(new User(23201, "bucky"));
        addUser(new User(2147483647, "sophia"));
    }
}
