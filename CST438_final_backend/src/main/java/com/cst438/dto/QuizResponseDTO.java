package com.cst438.dto;

public class QuizResponseDTO {
    private String attempt; // The user's guess for the country name
    private String correctCountry; // The actual correct country name for the flag

    // Default no-args constructor
    public QuizResponseDTO() {
    }

    // All-args constructor
    public QuizResponseDTO(String attempt, String correctCountry) {
        this.attempt = attempt;
        this.correctCountry = correctCountry;
    }

    // Getters and setters
    public String getAttempt() {
        return attempt;
    }

    public void setAttempt(String attempt) {
        this.attempt = attempt;
    }

    public String getCorrectCountry() {
        return correctCountry;
    }

    public void setCorrectCountry(String correctCountry) {
        this.correctCountry = correctCountry;
    }
}
