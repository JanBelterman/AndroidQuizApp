package com.janbe.quiz.domain;

/**
 * Created by janbe on 15-Mar-18.
 */

// Enumeration for the available quiz subjects
public enum Subject {

    CAPITAL_CITIES("Capital cities"),
    COMPUTER_SCIENCE("Computer science"),
    MATHS("Maths");

    private final String description;

    Subject(String description) {
        this.description = description;

    }

    public String getDescription() {
        return description;

    }

}
