package com.cst438.domain;

public class QuizFlag {
    private String name;
    private String flagUrl; // URL to the flag image

    // Constructor that matches the usage in FlagService
    public QuizFlag(String name, String flagUrl) {
        this.name = name;
        this.flagUrl = flagUrl;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFlagUrl() {
        return flagUrl;
    }

    public void setFlagUrl(String flagUrl) {
        this.flagUrl = flagUrl;
    }
}
