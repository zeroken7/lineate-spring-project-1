package com.example.lineatespring.repositories;

import com.example.lineatespring.models.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserRepository {

    private HashMap<Integer, User> users = new HashMap<Integer, User>();

    public List<User> getAllUsers() {
        return new ArrayList<>(users.values());
    }

    public void addUser(User user) {
        users.put(user.getId(), user);
    }
}
