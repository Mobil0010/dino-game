package com.chrome.dinogame.dinogame.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chrome.dinogame.dinogame.entity.User;
import com.chrome.dinogame.dinogame.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public User signup(@RequestBody User user) {
        return userService.register(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User loginUser) {
        Optional<User> user = userService.login(loginUser.getUsername(), loginUser.getPassword());
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인 실패: 아이디 또는 비밀번호 오류");
        }
    }

    @GetMapping("/{username}")
    public Optional<User> getUser(@PathVariable String username) {
        return userService.findByUsername(username);
    }
}