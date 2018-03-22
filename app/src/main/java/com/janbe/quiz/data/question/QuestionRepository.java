package com.janbe.quiz.data.question;

import com.janbe.quiz.domain.Subject;
import com.janbe.quiz.domain.question.Question;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by janbe on 07-Mar-18.
 */

public interface QuestionRepository extends Serializable {

    ArrayList<Question> getQuestions(Subject subject);

}
