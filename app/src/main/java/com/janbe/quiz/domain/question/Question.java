package com.janbe.quiz.domain.question;

import com.janbe.quiz.domain.answer.Answer;
import com.janbe.quiz.domain.explanation.Explanation;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by janbe on 10-Mar-18.
 */

public interface Question extends Serializable {

    QuestionType getQuestionType();

    String getQuestion();
    Answer getRightAnswer();
    ArrayList<Answer> getWrongAnswers();
    Explanation getExplanation();

}
