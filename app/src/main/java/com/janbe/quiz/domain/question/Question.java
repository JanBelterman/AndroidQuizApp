package com.janbe.quiz.domain.question;

import com.janbe.quiz.domain.answer.Answer;
import com.janbe.quiz.domain.explanation.Explanation;

import java.io.Serializable;
import java.util.ArrayList;

public interface Question extends Serializable {

    String getQuestion();
    Answer getRightAnswer();
    ArrayList<Answer> getWrongAnswers();
    Explanation getExplanation();

}
