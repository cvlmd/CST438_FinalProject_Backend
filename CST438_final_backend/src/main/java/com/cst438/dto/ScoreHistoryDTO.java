package com.cst438.dto;



public class ScoreHistoryDTO {

    private String attemptId;
    private String userGuess;
    private String correctCountry;
    private boolean isCorrect;
	public String getAttemptId() {
		return attemptId;
	}
	public void setAttemptId(String attemptId) {
		this.attemptId = attemptId;
	}
	public String getUserGuess() {
		return userGuess;
	}
	public void setUserGuess(String userGuess) {
		this.userGuess = userGuess;
	}
	public String getCorrectCountry() {
		return correctCountry;
	}
	public void setCorrectCountry(String correctCountry) {
		this.correctCountry = correctCountry;
	}
	public boolean isCorrect() {
		return isCorrect;
	}
	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}

}

