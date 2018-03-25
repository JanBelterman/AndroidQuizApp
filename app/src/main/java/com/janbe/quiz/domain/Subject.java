package com.janbe.quiz.domain;

import com.janbe.quiz.R;

// Enumeration for the available quiz subjects
public enum Subject {

    CAPITAL_CITIES(true, R.string.capitalCities),
    COMPUTER_SCIENCE(false, R.string.computerScience),
    MATHS(false, R.string.maths);

    private final boolean isGeneralQuestion;
    private final int description;

    Subject(boolean isGeneralQuestion, int description) {
        this.description = description;
        this.isGeneralQuestion = isGeneralQuestion;

    }

    public int getDescription() {
        return description;

    }

    public boolean isGeneralQuestion() {
        return isGeneralQuestion;

    }

}
