package com.janbe.quiz.logic.quiz.result;

import com.janbe.quiz.logic.quiz.score.Score;

import java.io.Serializable;

public interface Result extends Serializable {

    void putScore(Score score);
    Class getFeedbackScreenClass();
    Score getScore();

}
