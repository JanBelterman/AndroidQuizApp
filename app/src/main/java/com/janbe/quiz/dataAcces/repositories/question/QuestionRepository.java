package com.janbe.quiz.dataAcces.repositories.question;

import com.janbe.quiz.domain.Subject;
import com.janbe.quiz.domain.question.Question;

import java.io.Serializable;
import java.util.ArrayList;

public interface QuestionRepository extends Serializable {

    ArrayList<Question> getQuestions(Subject subject);

}
