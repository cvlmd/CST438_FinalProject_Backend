package com.cst438.service.test;


import com.cst438.domain.QuizFlag;
import com.cst438.service.FlagService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class JUnitFlagServiceTest {

    @Mock
    private RestTemplate restTemplate;

    private FlagService flagService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        flagService = new FlagService(restTemplate);
    }

    @Test
    public void testGetRandomFlag() {
        // Create a sample response from the API
        FlagService.Country[] sampleResponse = new FlagService.Country[]{
            createSampleCountry("France", "france_flag_url"),
            createSampleCountry("Germany", "germany_flag_url")
        };

        // Mock the restTemplate to return the sample response
        when(restTemplate.getForObject(anyString(), eq(FlagService.Country[].class)))
            .thenReturn(sampleResponse);

        // Call the getRandomFlag method
        QuizFlag randomFlag = flagService.getRandomFlag();

        // Verify that the restTemplate was called
        verify(restTemplate, times(1)).getForObject(anyString(), eq(FlagService.Country[].class));

        // Check if the result is not null
        assertNotNull(randomFlag);

        // Check if the country name is one of the sample countries
        assertTrue(randomFlag.getName().equals("France") || randomFlag.getName().equals("Germany"));

        // Check if the flag URL is not null or empty
        assertNotNull(randomFlag.getFlagUrl());
    }

    private FlagService.Country createSampleCountry(String name, String flagUrl) {
        FlagService.Country country = new FlagService.Country();
        country.setName(name);
        country.setFlags(Map.of("png", flagUrl));
        return country;
    }
}
