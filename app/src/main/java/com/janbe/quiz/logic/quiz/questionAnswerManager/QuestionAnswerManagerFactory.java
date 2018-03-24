package com.janbe.quiz.logic.quiz.questionAnswerManager;

import com.janbe.quiz.data.factory.RepositoryFactory;
import com.janbe.quiz.domain.question.GeneralAnsweredQuestion;
import com.janbe.quiz.domain.question.Question;
import com.janbe.quiz.logic.settings.QuizSetting;

/**
 * Created by janbe on 24-Mar-18.
 */

// Simple factory to determine which QuestionAnswerManager has to be used in the quiz.
// - First checks quiz type
// - Secondly checks the questions types of the quiz (subject defined)
public class QuestionAnswerManagerFactory {

    public QuestionAnswerManager getQuestionAnswerManager(QuizSetting quizType,
                                                          boolean isGeneralQuestion,
                                                          RepositoryFactory repositoryFactory) {

        if (quizType == QuizSetting.SETTING_QUIZ_LONG_LIST) {
            return new LongListQuestionAnswerManager(repositoryFactory);

        } else {

            if (isGeneralQuestion) {
                return new MultipleChoiceGeneralQuestionAnswerManager(repositoryFactory);

            } else {
                return new MultipleChoiceSpecificQuestionAnswerManager(repositoryFactory);

            }

        }

    }

}
