package com.janbe.quiz.logic.quiz.questionAnswerManager;

import com.janbe.quiz.data.factory.RepositoryFactory;
import com.janbe.quiz.domain.Subject;
import com.janbe.quiz.domain.answer.Answer;
import com.janbe.quiz.domain.question.Question;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by janbe on 15-Mar-18.
 */

public interface QuestionAnswerManager extends Serializable {

    void setUp(int amountOfQuestions, Subject subject);
    Question getQuestion(int questionIndex);
    ArrayList<Answer> getAnswers(int questionIndex);

}
