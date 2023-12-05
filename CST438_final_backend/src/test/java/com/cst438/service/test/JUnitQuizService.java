package com.cst438.service.test;

import com.cst438.domain.QuizFlag;
import com.cst438.service.FlagService;
import com.cst438.service.QuizService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class JUnitQuizService {

    private QuizService quizService;

    @Mock
    private FlagService flagService;

    @BeforeEach
    public void setUp() {
        quizService = new QuizService(flagService);
    }

    @Test
    public void testGetNextFlag() {
        // Mock the behavior of flagService.getRandomFlag() to return a known QuizFlag
        QuizFlag expectedFlag = new QuizFlag("Test Country", "test_flag_url");
        when(flagService.getRandomFlag()).thenReturn(expectedFlag);

        QuizFlag actualFlag = quizService.getNextFlag();

        assertEquals(expectedFlag, actualFlag);
    }

    @Test
    public void testCheckAnswerCorrect() {
        // Mock the behavior of flagService.checkGuess() to return true (correct answer)
        String attempt = "Test Country";
        String correctCountry = "Test Country";
        when(flagService.checkGuess(attempt, correctCountry)).thenReturn(true);

        String result = quizService.checkAnswer(attempt, correctCountry);

        assertEquals("Correct!", result);
    }

    @Test
    public void testCheckAnswerIncorrect() {
        // Mock the behavior of flagService.checkGuess() to return false (incorrect answer)
        String attempt = "Test Country";
        String correctCountry = "Correct Country";
        when(flagService.checkGuess(attempt, correctCountry)).thenReturn(false);

        String result = quizService.checkAnswer(attempt, correctCountry);

        assertEquals("Incorrect, the correct answer was Correct Country. Try another flag!", result);
    }
}
