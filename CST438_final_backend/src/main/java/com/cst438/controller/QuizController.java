package com.cst438.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cst438.dto.QuizDifficultyDTO;
import com.cst438.service.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping("/start")
    public ResponseEntity<?> startQuiz(@RequestBody QuizDifficultyDTO difficulty) {
        String sessionId = quizService.startQuiz(difficulty.getLevel());
        return ResponseEntity.ok(sessionId);
    }

    @GetMapping("/next-flag")
    public ResponseEntity<?> getNextFlag(@RequestParam String sessionId) {
        String flag = quizService.getNextFlag(sessionId);
        return ResponseEntity.ok(flag);
    }

    @PostMapping("/submit-answer")
    public ResponseEntity<?> submitAnswer(@RequestParam String sessionId, @RequestParam String answer) {
        boolean isCorrect = quizService.submitAnswer(sessionId, answer);
        return ResponseEntity.ok(isCorrect);
    }
}
