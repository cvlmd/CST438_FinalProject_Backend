package com.cst438.service;

import com.cst438.domain.QuizFlag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuizService {

    private final FlagService flagService;

    @Autowired
    public QuizService(FlagService flagService) {
        this.flagService = flagService;
    }

    public QuizFlag getNextFlag() {
        return flagService.getRandomFlag();
    }

    public String checkAnswer(String userGuess, String correctCountry) {
        boolean isCorrect = flagService.checkGuess(userGuess, correctCountry);
        return isCorrect ? "Correct!" : "Incorrect, the correct answer was " + correctCountry + ". Try another flag!";
    }
}
