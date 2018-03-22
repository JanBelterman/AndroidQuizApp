package com.janbe.quiz.logic.settings;

/**
 * Created by janbe on 19-Mar-18.
 */

public enum QuizSetting {

    SETTING_QUIZ_MULTIPLE_CHOICE("Multiple choice"),
    SETTING_QUIZ_LONG_LIST("Long list"),
    SETTING_SCORE_RATIO_SCORE("Ratio score"),
    SETTING_SCORE_TIMED_SCORE("Timed score");

    private final String description;

    QuizSetting(String description) {
        this.description = description;

    }

    public String getDescription() {
        return description;

    }

}
