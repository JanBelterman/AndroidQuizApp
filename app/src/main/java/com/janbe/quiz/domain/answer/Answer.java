package com.janbe.quiz.domain.answer;

import java.io.Serializable;

/**
 * Created by janbe on 06-Mar-18.
 */

public class Answer implements Serializable {
    private String answer;

    public Answer(String answer) {
        this.answer = answer;

    }

    public String getAnswer() {
        return answer;

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

        if (this.answer.equals((answer.getAnswer()))) {
            return true;

        }

        return false;

    }

}
