package com.cst438.service.test;


import com.cst438.domain.FlagRepository;
import com.cst438.dto.QuizDifficultyDTO;
import com.cst438.service.QuizService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class QuizServiceTest {

    @Mock
    private FlagRepository flagRepository;

    @InjectMocks
    private QuizService quizService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getNextFlagTest() {
        // Arrange
        QuizDifficultyDTO difficulty = new QuizDifficultyDTO();
        difficulty.setLevel("easy");
        when(flagRepository.findSomehowByDifficulty(difficulty.getLevel())).thenReturn("url_to_flag_image");

        // Act
        String flagUrl = quizService.getNextFlag(difficulty);

        // Assert
        assertNotNull(flagUrl);
        assertEquals("url_to_flag_image", flagUrl);
    }

    // Other tests...
}
