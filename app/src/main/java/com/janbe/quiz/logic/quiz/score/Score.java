package com.janbe.quiz.logic.quiz.score;

import java.io.Serializable;

public interface Score extends Serializable {

    void nextQuestion();
    void questionAnswered(Boolean result);
    String getScore();
    int getTotalAnswers();
    int getGoodAnswers();

}
