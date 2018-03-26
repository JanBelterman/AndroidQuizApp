package com.janbe.quiz.userInterface.quiz.multipleChoiceQuiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.janbe.quiz.R;
import com.janbe.quiz.domain.answer.Answer;
import com.janbe.quiz.logic.quiz.result.Result;
import com.janbe.quiz.logic.quiz.Quiz;
import com.janbe.quiz.userInterface.quiz.QuizScreen;

import java.util.ArrayList;

public class MultipleChoiceQuizActivity extends AppCompatActivity implements QuizScreen {

    // Quiz manager
    private Quiz quiz;
    // Text views for question, answers and score
    private TextView questionText;
    private TextView answer1Text;
    private TextView answer2Text;
    private TextView answer3Text;
    private TextView answer4Text;
    private TextView scoreText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_multiple_choise);

        // Get quiz from intent, parsed from quiz selector activity (MainActivity)
        Intent intent = getIntent();
        quiz = (Quiz) intent.getSerializableExtra("QUIZ");

        // Getting text views
        questionText = findViewById(R.id.mcQuestionText);
        answer1Text = findViewById(R.id.mcAnswer1Text);
        answer2Text = findViewById(R.id.mcAnswer2Text);
        answer3Text = findViewById(R.id.mcAnswer3Text);
        answer4Text = findViewById(R.id.mcAnswer4Text);
        scoreText = findViewById(R.id.mcScoreText);

        // Launching quiz
        quiz.start();
        // Displaying quiz's first question
        updateDisplay();

    }

    // SEQUENCE WHEN USER CLICKS AN ANSWER
    // 1. listeners called when an answer is clicked by the user
    // - gets answer from the (by the user) clicked text view
    // - aks quiz if answer is correct
    // - display result
    // - display updated score
    // - init new question with helper method
    public void answer1Clicked(View view) {
        answerClicked(1);
    }
    public void answer2Clicked(View view) {
        answerClicked(2);
    }
    public void answer3Clicked(View view) {
        answerClicked(3);
    }
    public void answer4Clicked(View view) {
        answerClicked(4);
    }
    public void answerClicked(int answer) {

        // Get clicked answer
        Answer answerClicked = getAnswerFromTextViews(answer);
        // Aks quiz if answer is correct
        boolean result = quiz.questionAnswered(answerClicked);
        // Display result to user
        showResult(result);
        // Try putting next question on screen
        tryNextQuestion();

    }

    // 2. Tries to continue to next question
    // - notifies quiz to continue and updates display
    // or
    // - ends quiz and shows result screen
    private void tryNextQuestion() {

        // Notify quiz to proceed to next question
        // - if quiz returns false, than end quiz
        if (quiz.tryNextQuestion()) {
            // Put next round on screen
            updateDisplay();

        } else {
            endQuiz();

        }

    }

    // Display new question:
    // - score
    // - question and answers
    private void updateDisplay() {

        // Display quiz's updated score
        scoreText.setText(quiz.getScore().getScore());
        // Display new question and answers
        questionText.setText(quiz.getQuestion().getQuestion()); // Asking current question
        // Ask quiz for 4 answers, return consists of one correct answer, other 3 are random general or specific false answers
        ArrayList<Answer> answers = quiz.getAnswers();
        // Display answers
        answer1Text.setText(answers.get(0).getAnswer());
        answer2Text.setText(answers.get(1).getAnswer());
        answer3Text.setText(answers.get(2).getAnswer());
        answer4Text.setText(answers.get(3).getAnswer());

    }

    // End quiz and create result screen
    private void endQuiz() {
        // Get result data from quiz
        Result result = quiz.getResult();
        // Setup intent from quiz screen to result screen
        Intent intent = new Intent(this, result.getFeedbackScreenClass());
        // Send result data to result screen
        intent.putExtra("RESULT", result);
        // Start result activity
        startActivity(intent);
        // Close quiz activity
        finish();

    }

    // HELPER METHODS
    // --------------------------------------------------------------------------------------------------------- //

    // Helper method that returns the answer displayed in a text view
    private Answer getAnswerFromTextViews(int textViewIndex) {

        switch (textViewIndex) {

            case 1: return new Answer(answer1Text.getText().toString());
            case 2: return new Answer(answer2Text.getText().toString());
            case 3: return new Answer(answer3Text.getText().toString());
            case 4: return new Answer(answer4Text.getText().toString());

        }

        return null;

    }

    // Helper method that shows "Correct" or "False" Toast to user
    private void showResult(Boolean result) {
        String message;
        if (result) {
            message = getString(R.string.correctMes);
        } else {
            message = getString(R.string.falseMes);
        }
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

    }

}
