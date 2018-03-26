package com.janbe.quiz.domain.question;

import com.janbe.quiz.domain.answer.Answer;
import com.janbe.quiz.domain.explanation.Explanation;

import java.util.ArrayList;
import java.util.Locale;

public class GeneralAnsweredQuestion implements Question {

    private String questionEn;
    private String questionNl;
    private Answer rightAnswer;
    private Explanation explanation;

    public GeneralAnsweredQuestion(String questionEn,
                                   String questionNl,
                                   Answer rightAnswer,
                                   Explanation explanation) {

        this.questionEn = questionEn;
        this.questionNl = questionNl;
        this.rightAnswer = rightAnswer;
        this.explanation = explanation;

    }

    @Override
    public String getQuestion() {

        if (Locale.getDefault().getDisplayLanguage().contentEquals("en")) {
            return questionEn;

        } else {
            return questionNl;

        }

    }

    @Override
    public Answer getRightAnswer() {
        return rightAnswer;

    }

    @Override
    public ArrayList<Answer> getWrongAnswers() {
        return null;

    }

    @Override
    public Explanation getExplanation() {
        return explanation;

    }

}
