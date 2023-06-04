package com.example.lineatespring.repositories;

import org.springframework.stereotype.Repository;

import java.util.HashSet;

@Repository
public class AuthorizationRepository {

    private HashSet<Integer> authorizedUsers = new HashSet<Integer>();
    public void authorize(int userId) {
        authorizedUsers.add(userId);
    }

    public boolean isAuthorized(int userId) {
        return authorizedUsers.contains(userId);
    }
}
