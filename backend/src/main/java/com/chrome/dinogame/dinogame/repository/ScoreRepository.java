package com.chrome.dinogame.dinogame.repository;

import com.chrome.dinogame.dinogame.entity.Score;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ScoreRepository extends MongoRepository<Score, String> {
    List<Score> findByUserIdOrderByValueDesc(String userId);
}
