package com.janbe.quiz.logic.quiz;

import com.janbe.quiz.domain.answer.Answer;
import com.janbe.quiz.domain.question.Question;
import com.janbe.quiz.logic.quiz.result.Result;
import com.janbe.quiz.logic.quiz.score.Score;

import java.io.Serializable;
import java.util.ArrayList;

public interface Quiz extends Serializable {

    // QUIZ START //
    // ------------------------------------------------ //

    // To start quiz
    void start();

    // Get questions and answers
    Question getQuestion();
    int getQuestionNr();
    ArrayList<Answer> getAnswers();

    // Question answered
    boolean questionAnswered(Answer answer);

    // Method UI can call to check if quiz finished and move to next question
    boolean tryNextQuestion();

    // QUIZ END //
    // ------------------------------------------------ //

    // Get score from quiz
    Score getScore();
    // Get feedback from quiz
    Result getResult();

}
