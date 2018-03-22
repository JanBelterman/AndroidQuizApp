package com.janbe.quiz.data.factory;

import com.janbe.quiz.data.answer.AnswerRepository;
import com.janbe.quiz.data.question.QuestionRepository;

import java.io.Serializable;

/**
 * Created by janbe on 09-Mar-18.
 */

public interface RepositoryFactory extends Serializable {

    QuestionRepository getQuestionRepository();
    AnswerRepository getAnswerRepository();

}
