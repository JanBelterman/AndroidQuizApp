package com.janbe.quiz.logic.quiz.score;

public class StreakScore implements Score {

    private int totalQuestion;
    private int answeredCorrectly;

    private int streak;
    private int score;

    // Constructor
    public StreakScore() {

        totalQuestion = 0;
        answeredCorrectly = 0;
        streak = 0;

    }

    @Override
    public void nextQuestion() {
        totalQuestion ++;

    }

    @Override
    public void questionAnswered(Boolean result) {

        if (result) {
            answeredCorrectly ++;
            streak ++;

        } else {
            streak = 0;

        }

        score += 100 * streak;

    }

    @Override
    public String getScore() {
        return String.valueOf(score);

    }

    @Override
    public int getTotalAnswers() {
        return totalQuestion;

    }

    @Override
    public int getGoodAnswers() {
        return answeredCorrectly;

    }

}
