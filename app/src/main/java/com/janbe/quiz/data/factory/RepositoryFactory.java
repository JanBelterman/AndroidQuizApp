package com.janbe.quiz.data.factory;

import com.janbe.quiz.data.answer.AnswerRepository;
import com.janbe.quiz.data.question.QuestionRepository;

import java.io.Serializable;

public interface RepositoryFactory extends Serializable {

    QuestionRepository getQuestionRepository();
    AnswerRepository getAnswerRepository();

}
