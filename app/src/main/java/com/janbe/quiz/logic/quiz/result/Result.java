package com.janbe.quiz.logic.quiz.result;

import com.janbe.quiz.logic.quiz.score.Score;

import java.io.Serializable;

/**
 * Created by janbe on 06-Mar-18.
 */

public interface Result extends Serializable {

    void putScore(Score score);

    Class getFeedbackScreenClass();

    Score getScore();

}
