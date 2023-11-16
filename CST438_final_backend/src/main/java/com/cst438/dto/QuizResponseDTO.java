package com.cst438.dto;



public class QuizResponseDTO {

    private String flagId; // Or some identifier for the flag
    private String countryGuess;
	public String getFlagId() {
		return flagId;
	}
	public void setFlagId(String flagId) {
		this.flagId = flagId;
	}
	public String getCountryGuess() {
		return countryGuess;
	}
	public void setCountryGuess(String countryGuess) {
		this.countryGuess = countryGuess;
	}

    // Getters and setters
}
