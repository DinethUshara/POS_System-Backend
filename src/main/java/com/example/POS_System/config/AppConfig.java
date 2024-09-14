package com.example.POS_System.config;

import com.example.POS_System.service.UserService;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    private final UserService userService;

    public AppConfig(UserService userService) {
        this.userService = userService;
    }

    public UserService getUserService() {
        return userService;
    }
}
