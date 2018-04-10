package com.janbe.quiz.dataAcces.factory;

import com.janbe.quiz.dataAcces.repositories.answer.AnswerRepository;
import com.janbe.quiz.dataAcces.repositories.answer.SQLAnswerRepository;
import com.janbe.quiz.dataAcces.repositories.question.QuestionRepository;
import com.janbe.quiz.dataAcces.repositories.question.SQLQuestionRepository;

public class SQLRepositoryFactory implements RepositoryFactory {

    @Override
    public QuestionRepository getQuestionRepository() {
        return new SQLQuestionRepository();
    }

    @Override
    public AnswerRepository getAnswerRepository() {
        return new SQLAnswerRepository();
    }

}
