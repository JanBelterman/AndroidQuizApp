package com.janbe.quiz.domain.answer;

import java.io.Serializable;
import java.util.Locale;

public class Answer implements Serializable {
    private String answerEn;
    private String answerNl;

    public Answer(String answer) {
        this.answerEn = answer;
        this.answerNl = answer;

    }

    public Answer(String answerEn, String answerNl) {
        this.answerEn = answerEn;
        this.answerNl = answerNl;

    }

    public String getAnswer() {

        if (Locale.getDefault().getDisplayLanguage().contentEquals("Nederlands")) {
            return answerNl;

        } else {
            return answerEn;

        }

    }

    @Override
    public boolean equals(Object toCompare) {

        if (toCompare == null) {
            return false;

        }

        if (!(toCompare.getClass() == this.getClass())) {
            return false;

        }

        Answer answer = (Answer) toCompare;

        return this.getAnswer().equals((answer.getAnswer()));

    }

}
