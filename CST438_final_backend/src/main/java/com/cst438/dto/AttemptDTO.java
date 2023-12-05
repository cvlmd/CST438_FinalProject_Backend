package com.cst438.dto;



public class AttemptDTO {

    public AttemptDTO(String attemptId, String userId, String flagId, String countryGuessed, boolean isCorrect) {
		super();
		this.attemptId = attemptId;
		this.userId = userId;
		this.flagId = flagId;
		this.countryGuessed = countryGuessed;
		this.isCorrect = isCorrect;
	}
	private String attemptId;
    private String userId;
    private String flagId;
    private String countryGuessed;
    private boolean isCorrect;
	public String getAttemptId() {
		return attemptId;
	}
	public void setAttemptId(String attemptId) {
		this.attemptId = attemptId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getFlagId() {
		return flagId;
	}
	public void setFlagId(String flagId) {
		this.flagId = flagId;
	}
	public String getCountryGuessed() {
		return countryGuessed;
	}
	public void setCountryGuessed(String countryGuessed) {
		this.countryGuessed = countryGuessed;
	}
	public boolean isCorrect() {
		return isCorrect;
	}
	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}

    // Constructors, getters, and setters
}
