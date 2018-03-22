package com.janbe.quiz.logic.quiz.score;

import java.io.Serializable;

/**
 * Created by janbe on 06-Mar-18.
 */

public interface Score extends Serializable {

    void nextQuestion();

    void questionAnswered(Boolean result);

    String getScore();

    int getTotalAnswers();

    int getGoodAnswers();

}
