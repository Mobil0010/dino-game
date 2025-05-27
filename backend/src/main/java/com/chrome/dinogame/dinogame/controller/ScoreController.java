package com.chrome.dinogame.dinogame.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chrome.dinogame.dinogame.entity.Score;
import com.chrome.dinogame.dinogame.repository.ScoreRepository;

@RestController
@RequestMapping("/score")
@CrossOrigin
public class ScoreController {

    @Autowired
    private ScoreRepository scoreRepository;

    @PostMapping("/save")
    public ResponseEntity<Map<String, String>> saveScore(@RequestBody Score score) {
        scoreRepository.save(score);
        Map<String, String> response = new HashMap<>();
        response.put("message", "점수 저장 완료");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/user/{userId}")
    public List<Score> getUserScores(@PathVariable String userId) {
        return scoreRepository.findByUserIdOrderByValueDesc(userId);
    }
}
