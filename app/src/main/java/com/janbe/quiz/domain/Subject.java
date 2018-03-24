package com.janbe.quiz.domain;

/**
 * Created by janbe on 15-Mar-18.
 */

// Enumeration for the available quiz subjects
public enum Subject {

    CAPITAL_CITIES(true, "Capital cities"),
    COMPUTER_SCIENCE(false, "Computer science"),
    MATHS(false, "Maths");

    private final boolean isGeneralQuestion;
    private final String description;

    Subject(boolean isGeneralQuestion, String description) {
        this.description = description;
        this.isGeneralQuestion = isGeneralQuestion;

    }

    public String getDescription() {
        return description;

    }

    public boolean isGeneralQuestion() {
        return isGeneralQuestion;

    }

}
