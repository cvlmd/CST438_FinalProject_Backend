package com.cst438.controller.test;

import com.cst438.domain.QuizFlag;
import com.cst438.dto.QuizResponseDTO;
import com.cst438.service.QuizService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.authentication;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test") // Use a test profile with mocked dependencies
public class JUnitQuizControllerIntegration {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private QuizService quizService;

    @Test
    public void testGetRandomFlag() throws Exception {
        // Mock the behavior of quizService.getNextFlag() to return a known QuizFlag
        QuizFlag quizFlag = new QuizFlag("Test Country", "test_flag_url");
        when(quizService.getNextFlag()).thenReturn(quizFlag);

        mockMvc.perform(MockMvcRequestBuilders.get("/quiz/flag")
            .contentType(MediaType.APPLICATION_JSON)
            .with(authentication(getMockAuthentication()))) // Use the mock authentication
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.country").value("Test Country"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.flagUrl").value("test_flag_url"));
    }

    @Test
    public void testSubmitGuess() throws Exception {
        // Mock the behavior of quizService.checkAnswer() to return a known message
        String expectedMessage = "Correct!";
        when(quizService.checkAnswer("Test Country", "Correct Country")).thenReturn(expectedMessage);

        QuizResponseDTO quizResponse = new QuizResponseDTO("Test Country", "Correct Country");

        mockMvc.perform(MockMvcRequestBuilders.post("/quiz/guess")
            .with(authentication(getMockAuthentication())) // Use the mock authentication
            .contentType(MediaType.APPLICATION_JSON)
            .content(asJsonString(quizResponse))) // Convert the DTO to JSON
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().string(expectedMessage));
    }

    // Helper method to create mock authentication
    private Authentication getMockAuthentication() {
        UserDetails userDetails = new User("user", "user", AuthorityUtils.createAuthorityList("ROLE_USER"));
        return new UsernamePasswordAuthenticationToken(userDetails, "user", userDetails.getAuthorities());
    }

    // Helper method to convert objects to JSON strings
    private static String asJsonString(final Object obj) throws Exception {
        return new ObjectMapper().writeValueAsString(obj);
    }
}
