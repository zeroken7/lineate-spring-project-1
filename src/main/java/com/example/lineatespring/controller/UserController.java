package com.example.lineatespring.controller;

import com.example.lineatespring.models.User;
import com.example.lineatespring.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.getAll();
    }

    @GetMapping("/fill")
    public void fill() {
        userService.addDummyData();
    }

    @PostMapping("/add")
    public void add(@RequestBody User user) {
        userService.addUser(user);
    }
}
