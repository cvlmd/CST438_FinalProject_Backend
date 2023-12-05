package com.cst438.controller.test;

import com.cst438.controller.ScoreController;
import com.cst438.dto.ScoreHistoryDTO;
import com.cst438.service.ScoreService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JUnitScoreController {

    @InjectMocks
    private ScoreController scoreController;

    @Mock
    private ScoreService scoreService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetScoreHistory() {
        // Create a sample list of ScoreHistoryDTO
        List<ScoreHistoryDTO> historyList = new ArrayList<>();
        ScoreHistoryDTO history1 = new ScoreHistoryDTO();
        history1.setAttemptId("1L");
        history1.setUserGuess("user1");
        history1.setCorrectCountry("country1");
        history1.setCorrect(true);

        ScoreHistoryDTO history2 = new ScoreHistoryDTO();
        history2.setAttemptId("2L");
        history2.setUserGuess("user2");
        history2.setCorrectCountry("country2");
        history2.setCorrect(false);

        historyList.add(history1);
        historyList.add(history2);

        // Mock the behavior of scoreService
        when(scoreService.getScoreHistory("user1")).thenReturn(historyList);

        // Call the method to test
        ResponseEntity<List<ScoreHistoryDTO>> responseEntity = scoreController.getScoreHistory("user1");
        List<ScoreHistoryDTO> result = responseEntity.getBody();

        // Verify the result
        assertEquals(historyList.size(), result.size());
        assertEquals(historyList.get(0).getAttemptId(), result.get(0).getAttemptId());
        assertEquals(historyList.get(0).getUserGuess(), result.get(0).getUserGuess());
        assertEquals(historyList.get(0).getCorrectCountry(), result.get(0).getCorrectCountry());
        assertEquals(historyList.get(0).isCorrect(), result.get(0).isCorrect());

        assertEquals(historyList.get(1).getAttemptId(), result.get(1).getAttemptId());
        assertEquals(historyList.get(1).getUserGuess(), result.get(1).getUserGuess());
        assertEquals(historyList.get(1).getCorrectCountry(), result.get(1).getCorrectCountry());
        assertEquals(historyList.get(1).isCorrect(), result.get(1).isCorrect());

        // Verify that the scoreService method was called
        verify(scoreService, times(1)).getScoreHistory("user1");
    }
}
