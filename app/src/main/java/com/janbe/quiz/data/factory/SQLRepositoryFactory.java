package com.janbe.quiz.data.factory;

import com.janbe.quiz.data.answer.AnswerRepository;
import com.janbe.quiz.data.answer.SQLAnswerRepository;
import com.janbe.quiz.data.question.QuestionRepository;
import com.janbe.quiz.data.question.SQLQuestionRepository;

/**
 * Created by janbe on 15-Mar-18.
 */

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
