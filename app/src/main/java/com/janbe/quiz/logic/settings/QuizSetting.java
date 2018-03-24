package com.janbe.quiz.logic.settings;

import com.janbe.quiz.R;

/**
 * Created by janbe on 19-Mar-18.
 */

public enum QuizSetting {

    SETTING_QUIZ_MULTIPLE_CHOICE(R.string.multipleChoice),
    SETTING_QUIZ_LONG_LIST(R.string.longList),
    SETTING_SCORE_RATIO_SCORE(R.string.percentageCorrect),
    SETTING_SCORE_TIMED_SCORE(R.string.fastAnswers);

    private final int description;

    QuizSetting(int description) {
        this.description = description;

    }

    public int getDescription() {
        return description;

    }

}
