package com.cst438.dto;



public class ScoreHistoryDTO {

    private Long userId;
    private Integer score;
    private String quizDate; // Could also be a Date object
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public String getQuizDate() {
		return quizDate;
	}
	public void setQuizDate(String quizDate) {
		this.quizDate = quizDate;
	}

    // Getters and setters
}
