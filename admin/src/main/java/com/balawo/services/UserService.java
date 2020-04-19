package com.balawo.services;

import com.balawo.models.User;
import com.balawo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        var it = userRepository.findAll();
        var users = new ArrayList<User>();
        it.forEach(e -> users.add(e));
        return users;
    }

    public List<User> findAllByName(String name){
        var it = userRepository.findByNameLike(name);
        var users = new ArrayList<User>();
        it.forEach(e -> users.add(e));
        return users;
    }


}
