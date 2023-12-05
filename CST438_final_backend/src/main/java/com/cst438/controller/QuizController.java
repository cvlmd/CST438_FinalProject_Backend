package com.cst438.controller;

import com.cst438.domain.QuizFlag;
import com.cst438.dto.QuizResponseDTO;
import com.cst438.dto.ScoreHistoryDTO;
import com.cst438.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    private final QuizService quizService;

    @Autowired
    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping("/flag")
    public ResponseEntity<QuizFlag> getRandomFlag() {
        QuizFlag flag = quizService.getNextFlag();
        return ResponseEntity.ok(flag);
    }

    @PostMapping("/guess")
    public ResponseEntity<String> submitGuess(@RequestBody ScoreHistoryDTO quizResponse) {
        String message = quizService.checkAnswer(quizResponse.getAttemptId(), quizResponse.getCorrectCountry());
        return ResponseEntity.ok(message);
    }

}

