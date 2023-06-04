package com.example.lineatespring.services;

import com.example.lineatespring.repositories.AuthorizationRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService {

    private final AuthorizationRepository authorizationRepository
            = new AuthorizationRepository();

    public void authorize(int userId) {
        authorizationRepository.authorize(userId);
    }

    public boolean isAuthorized(int userId) {
        return authorizationRepository.isAuthorized(userId);
    }
}
