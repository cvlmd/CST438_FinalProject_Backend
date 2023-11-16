package com.cst438.service;

import com.cst438.domain.FlagRepository;
import com.cst438.dto.QuizDifficultyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class QuizService {

    private final FlagRepository flagRepository;

    @Autowired
    public QuizService(FlagRepository flagRepository) {
        this.flagRepository = flagRepository;
    }

    public String startQuiz(String difficultyLevel) {
        // Logic to initialize a quiz session and select flags based on difficulty
        // This can involve storing a session in the database or in memory with selected flags
        // For simplicity, we are just generating a random session ID here
        return UUID.randomUUID().toString();
    }

    public String getNextFlag(String sessionId) {
        // Logic to get the next flag for a given session
        // Retrieve the session and its current state, then select the next flag
        return "url_to_flag_image";
    }

    public boolean submitAnswer(String sessionId, String countryGuess) {
        // Logic to check if the answer is correct for the current flag in the session
        // Retrieve the session, check the current flag, and compare the guess
        return true; // or false
    }
}
