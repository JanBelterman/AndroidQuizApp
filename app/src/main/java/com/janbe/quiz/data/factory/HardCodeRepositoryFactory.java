package com.janbe.quiz.data.factory;

import com.janbe.quiz.data.answer.AnswerRepository;
import com.janbe.quiz.data.answer.HardCodeAnswerRepository;
import com.janbe.quiz.data.question.HardCodeQuestionRepository;
import com.janbe.quiz.data.question.QuestionRepository;

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
