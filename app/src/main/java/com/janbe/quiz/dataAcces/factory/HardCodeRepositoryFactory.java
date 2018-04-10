package com.janbe.quiz.dataAcces.factory;

import com.janbe.quiz.dataAcces.repositories.answer.AnswerRepository;
import com.janbe.quiz.dataAcces.repositories.answer.HardCodeAnswerRepository;
import com.janbe.quiz.dataAcces.repositories.question.HardCodeQuestionRepository;
import com.janbe.quiz.dataAcces.repositories.question.QuestionRepository;

public class HardCodeRepositoryFactory implements RepositoryFactory {

    @Override
    public QuestionRepository getQuestionRepository() {
        return new HardCodeQuestionRepository();

    }

    @Override
    public AnswerRepository getAnswerRepository() {
        return new HardCodeAnswerRepository();

    }

}
