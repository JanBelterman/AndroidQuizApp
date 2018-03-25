package com.janbe.quiz.domain.question;

import com.janbe.quiz.domain.answer.Answer;
import com.janbe.quiz.domain.explanation.Explanation;

import java.util.ArrayList;

public class GeneralAnsweredQuestion implements Question {

    private String question;
    private Answer rightAnswer;
    private Explanation explanation;

    public GeneralAnsweredQuestion(String question,
                                   Answer rightAnswer,
                                   Explanation explanation) {

        this.question = question;
        this.rightAnswer = rightAnswer;
        this.explanation = explanation;

    }

    @Override
    public String getQuestion() {
        return question;

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
