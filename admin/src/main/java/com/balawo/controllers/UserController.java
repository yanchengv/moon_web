package com.balawo.controllers;

import com.balawo.config.QiqiuProperties;
import com.balawo.models.User;
import com.balawo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private QiqiuProperties qiqiuProperties;

    @RequestMapping("/users/show")
    public User findById(Integer userId) {

        User user = userRepository.findById(userId).orElse(null);
        return user;
    }

    @GetMapping("/users")
    public List<User> findAll() {
        System.out.println(qiqiuProperties.getHostname());
        List<User> users = (List<User>) userRepository.findAll();
        return users;
    }
}
