package com.janbe.quiz.dataAcces.factory;

import com.janbe.quiz.dataAcces.repositories.answer.AnswerRepository;
import com.janbe.quiz.dataAcces.repositories.question.QuestionRepository;

import java.io.Serializable;

public interface RepositoryFactory extends Serializable {

    QuestionRepository getQuestionRepository();
    AnswerRepository getAnswerRepository();

}
