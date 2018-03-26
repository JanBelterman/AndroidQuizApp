package com.janbe.quiz.logic.quiz;

import com.janbe.quiz.domain.Subject;
import com.janbe.quiz.domain.answer.Answer;
import com.janbe.quiz.domain.question.Question;
import com.janbe.quiz.logic.quiz.result.Result;
import com.janbe.quiz.logic.quiz.questionAnswerManager.QuestionAnswerManager;
import com.janbe.quiz.logic.quiz.score.Score;

import java.util.ArrayList;

public class NormalQuiz implements Quiz {

    // Subject
    private Subject subject;
    // Amount of questions in quiz
    private int amountOfQuestions;
    // Score and result
    private Score score;
    private Result result;

    // Current question index and current question
    private int currentQuestionIndex;
    private Question currentQuestion;

    private QuestionAnswerManager questionAnswerManager;

    // QUIZ SETUP
    // --------------------------------------------------------------------------------------------------------- //

    public NormalQuiz(QuestionAnswerManager questionAnswerManager,
                      Subject subject,
                      int amountOfQuestions,
                      Score score,
                      Result result) {

        this.questionAnswerManager = questionAnswerManager;
        this.subject = subject;
        this.amountOfQuestions = amountOfQuestions;
        this.score = score;
        this.result = result;

    }

    // QUIZ START
    // --------------------------------------------------------------------------------------------------------- //

    // Initializes all questions into list
    // - for general answered questions also stores answers into list
    // - for specific answered questions, questions are retrieved for question specific, so nothing is done with answers in this method
    @Override
    public void start() { // Fun can be improved questions and answers object?

        questionAnswerManager.setUp(amountOfQuestions, subject);

        // First question index is -1, because nextQuestion sets always ups it by one
        currentQuestionIndex = -1;
        tryNextQuestion();

    }

    // Called from UI to check if next question exists or if quiz ended
    // - Return true if current question exists
    // - Return false is current question is null (when quiz is over)
    @Override
    public boolean tryNextQuestion() {

        // Set index to next question
        currentQuestionIndex ++;

        // Try getting next question from list
        // - if question is found than assign it to current question
        // - if question is out of bounds than return false
        try {
            currentQuestion = questionAnswerManager.getQuestion(currentQuestionIndex);
            score.nextQuestion();
        }
        // If question is not found prepare for end of quiz
        // - currentQuestion = null will result in hasNextQuestion() to return false
        // - the result object will store the score object to be displayed in the result screen
        // !!Result to result!!One option!!
        catch (Exception e) {
            currentQuestion = null;
            result.putScore(score);

        }

        // Return true if currentQuestions = null
        return currentQuestion != null;

    }

    // Returns current question
    // -1 because question starts at 1 and ArrayList at 0
    @Override
    public Question getQuestion() {
        return currentQuestion;

    }

    @Override
    public ArrayList<Answer> getAnswers() {
        return questionAnswerManager.getAnswers(currentQuestionIndex);

    }

    // Called when question is answered
    // - check question
    // - update score
    // - return result
    @Override
    public boolean questionAnswered(Answer answer) {

        // If answer is right
        if (answer.equals(currentQuestion.getRightAnswer())) {
            score.questionAnswered(true);
            return true;

        }
        // If answer is false
        else {
            score.questionAnswered(false);
            return false;

        }

    }

    // QUIZ END
    // --------------------------------------------------------------------------------------------------------- //

    // Returns current score
    @Override
    public Score getScore() {
        return this.score;

    }
    // Returns result, called at the end of the quiz
    @Override
    public Result getResult() {
        return result;

    }

}
