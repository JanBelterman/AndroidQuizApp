package com.janbe.quiz.logic.quiz.score;

public class TimedScore implements Score {

    private long score;
    private int totalAnswers;
    private int goodAnswers;

    private long startTime;

    public TimedScore() {
        score = 0;

    }


    @Override
    public void nextQuestion() {
        startTime = System.currentTimeMillis();

    }

    @Override
    public void questionAnswered(Boolean result) {

        totalAnswers ++;

        // If result is false, nothing is added to the score
        if (!result) {
            return;

        }

        goodAnswers ++;

        // Get current time
        long currentTime = System.currentTimeMillis();
        // Calculate difference between time when answer was displayed and when answer is answered
        // / 1000 to convert to seconds
        long decrease = (currentTime - startTime) / 1000;
        // Up the score with decrease calculated
        try {
            score += (1000) / decrease;
        } catch (ArithmeticException e) {
            score += (1000);

        }

    }

    @Override
    public String getScore() {
        return score + "";

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
