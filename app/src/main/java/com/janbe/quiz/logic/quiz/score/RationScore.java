package com.janbe.quiz.logic.quiz.score;

/**
 * Created by janbe on 06-Mar-18.
 */

public class RationScore implements Score {
    private int goodAnswers;
    private int totalAnswers;

    public RationScore() {
        goodAnswers = 0;
        totalAnswers = 0;
    }

    @Override
    public void nextQuestion() {


    }

    @Override
    public void questionAnswered(Boolean result) {
        totalAnswers++;

        if (result) {
            goodAnswers++;

        }

    }

    @Override
    public String getScore() {
        if (totalAnswers == 0) {
            return 0 + "%";
        }

        Double ratio = ((goodAnswers * 1.0) / (totalAnswers * 1.0)) * 100;

        return String.format("%.0f", ratio) + "%";

    }

    @Override
    public int getTotalAnswers() {
        return totalAnswers;

    }

    @Override
    public int getGoodAnswers() {
        return goodAnswers;

    }

}
