package com.cst438.service;

import com.cst438.domain.QuizFlag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@Service
public class FlagService {

    private final RestTemplate restTemplate;
    private final Random random = new Random();

    @Autowired
    public FlagService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public QuizFlag getRandomFlag() {
        String apiUrl = "https://restcountries.com/v2/all?fields=name,flags";
        Country[] countries = restTemplate.getForObject(apiUrl, Country[].class);
        if (countries == null || countries.length == 0) {
            throw new IllegalStateException("No flags available from the API.");
        }
        Country randomCountry = countries[random.nextInt(countries.length)];
        return new QuizFlag(randomCountry.getName(), randomCountry.getFlags().get("png"));
    }

    public boolean checkGuess(String attempt, String correctCountry) {
        return attempt.trim().equalsIgnoreCase(correctCountry.trim());
    }

    // Inner class to match the JSON structure of the API response
    public static class Country {
        private String name;
        private java.util.Map<String, String> flags;

        // Getters and setters
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public java.util.Map<String, String> getFlags() {
            return flags;
        }

        public void setFlags(java.util.Map<String, String> flags) {
            this.flags = flags;
        }
    }
}
