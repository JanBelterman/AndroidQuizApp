package com.janbe.quiz.data.answer;

import com.janbe.quiz.domain.Subject;
import com.janbe.quiz.domain.answer.Answer;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by janbe on 07-Mar-18.
 */

public interface AnswerRepository extends Serializable {

    ArrayList<Answer> getAnswers(Subject subject);

}
