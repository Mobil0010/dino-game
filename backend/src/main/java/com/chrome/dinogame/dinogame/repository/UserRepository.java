package com.chrome.dinogame.dinogame.repository;

import com.chrome.dinogame.dinogame.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByUsername(String username);
    Optional<User> findByNickname(String nickname);
}