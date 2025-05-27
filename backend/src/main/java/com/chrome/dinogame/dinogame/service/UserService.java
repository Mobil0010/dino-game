package com.chrome.dinogame.dinogame.service;

import com.chrome.dinogame.dinogame.entity.User;
import com.chrome.dinogame.dinogame.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User register(User user) {
        return userRepository.save(user);
    }

    public Optional<User> login(String username, String password) {
        return userRepository.findByUsername(username)
                .filter(u -> u.getPassword().equals(password));
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}