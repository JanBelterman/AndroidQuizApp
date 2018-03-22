package com.janbe.quiz.data.factory;

import com.janbe.quiz.data.answer.AnswerRepository;
import com.janbe.quiz.data.answer.HardCodeAnswerRepository;
import com.janbe.quiz.data.question.HardCodeQuestionRepository;
import com.janbe.quiz.data.question.QuestionRepository;

/**
 * Created by janbe on 15-Mar-18.
 */

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
