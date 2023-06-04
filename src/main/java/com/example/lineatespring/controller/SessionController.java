package com.example.lineatespring.controller;

import com.example.lineatespring.models.User;
import com.example.lineatespring.services.AuthorizationService;
import com.example.lineatespring.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/host")
public class SessionController {

    private final AuthorizationService authorizationService;
    private final UserService userService;

    public SessionController(AuthorizationService authorizationService, UserService userService) {
        this.authorizationService = authorizationService;
        this.userService = userService;
    }

    @GetMapping("/session/authorize/{userId}")
    public void authorize(@PathVariable int userId) {
        authorizationService.authorize(userId);
    }

    @GetMapping("/session/all")
    public List<User> getAuthorizedUsers() {
        return userService.getAll()
                .stream()
                .filter(user -> authorizationService.isAuthorized(user.getId()))
                .collect(Collectors.toList());
    }

}
