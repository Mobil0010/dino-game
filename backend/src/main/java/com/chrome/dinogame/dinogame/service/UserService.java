package com.chrome.dinogame.dinogame.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.chrome.dinogame.dinogame.entity.User;
import com.chrome.dinogame.dinogame.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User register(User user) {
        System.out.println(">>> 회원가입 시도: " + user.getUsername() + ", " + user.getPassword() + ", " + user.getNickname());

        try {
            if (user.getUsername() == null || user.getPassword() == null || user.getNickname() == null) {
                throw new IllegalArgumentException("입력값 누락");
            }

            if (userRepository.findByUsername(user.getUsername()).isPresent()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "username already exists");
            }
            if (userRepository.findByNickname(user.getNickname()).isPresent()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "nickname already exists");
            }

            return userRepository.save(user);

        } catch (Exception e) {
            e.printStackTrace(); // 콘솔 출력
            throw e; // 다시 던져서 Controller에서 처리
        }
    }


    public Optional<User> login(String username, String password) {
        return userRepository.findByUsername(username)
                .filter(u -> u.getPassword().equals(password));
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}