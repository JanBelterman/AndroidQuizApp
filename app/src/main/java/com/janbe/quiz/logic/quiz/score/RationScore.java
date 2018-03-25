package com.janbe.quiz.logic.quiz.score;

// RatioScore is a concrete instance of Score, which calculates score bases on the percentage of correct answers
public class RationScore implements Score {

    private int goodAnswers;
    private int totalAnswers;

    public RationScore() {
        goodAnswers = 0;
        totalAnswers = 0;
    }

    // Interface method that is not used in this concrete instance of Score
    @Override
    public void nextQuestion() {

    }

    // Add new result to the Score object
    @Override
    public void questionAnswered(Boolean result) {

        totalAnswers ++;

        if (result) {
            goodAnswers ++;

        }

    }

    // Calculated and returns the current score
    @Override
    public String getScore() {

        // Check if totalAnswers is 0, otherwise a divide with 0 may occur while calculating the ratio
        if (totalAnswers == 0) {
            return 0 + "%";
        }

        // Calculate ratio
        Double ratio = ((goodAnswers * 1.0) / (totalAnswers * 1.0)) * 100;

        // Return without decimals (70% instead of 70,6666667%)
        return Double.toString(Math.floor(ratio));

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
