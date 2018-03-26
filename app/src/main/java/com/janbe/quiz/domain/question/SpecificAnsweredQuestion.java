package com.janbe.quiz.domain.question;

import com.janbe.quiz.domain.answer.Answer;
import com.janbe.quiz.domain.explanation.Explanation;

import java.util.ArrayList;
import java.util.Locale;

public class SpecificAnsweredQuestion implements Question {

    private String questionEn;
    private String questionNl;
    private Answer rightAnswer;
    private ArrayList<Answer> wrongAnswers;
    private Explanation explanation;

    public SpecificAnsweredQuestion(String questionEn,
                                    String questionNl,
                                    Answer rightAnswer,
                                    Answer wrongAnswer1,
                                    Answer wrongAnswer2,
                                    Answer wrongAnswer3,
                                    Explanation explanation) {

        this.questionEn = questionEn;
        this.questionNl = questionNl;
        this.rightAnswer = rightAnswer;
        this.wrongAnswers = new ArrayList<>();
        this.wrongAnswers.add(wrongAnswer1);
        this.wrongAnswers.add(wrongAnswer2);
        this.wrongAnswers.add(wrongAnswer3);
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
        return wrongAnswers;

    }

    @Override
    public Explanation getExplanation() {
        return explanation;

    }

}
