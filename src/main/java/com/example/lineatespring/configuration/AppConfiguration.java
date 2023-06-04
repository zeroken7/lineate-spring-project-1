package com.example.lineatespring.configuration;

import com.example.lineatespring.models.User;
import com.example.lineatespring.repositories.UserRepository;
import com.example.lineatespring.services.UserService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Bean
    public UserRepository userRepository() {
        return new UserRepository();
    }

    @Bean
    @ConditionalOnProperty(prefix = "data", name = "empty", havingValue = "true")
    public UserService userServiceDataEmptyTrue(UserRepository userRepository) {
        return new UserService(userRepository);
    }

    @Bean
    @ConditionalOnProperty(prefix = "data", name = "empty", havingValue = "false")
    public UserService userServiceDataEmptyFalse(UserRepository userRepository) {
        UserService userService = new UserService(userRepository);
        userService.addUser(new User(1, "james"));
        userService.addUser(new User(2, "charles"));
        userService.addUser(new User(3, "mary"));
        return userService;
    }
}
