package com.janbe.quiz.userInterface.quiz.longListQuiz;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.janbe.quiz.R;
import com.janbe.quiz.domain.answer.Answer;
import com.janbe.quiz.logic.quiz.Quiz;
import com.janbe.quiz.logic.quiz.result.Result;

import java.util.ArrayList;


public class LongListQuizActivity extends AppCompatActivity {

    // Quiz manager
    Quiz quiz;

    private AnswerAdapter answerAdapter;

    private TextView questionText;
    private TextView scoreText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_long_list);

        // Get quiz from intent, parsed from quiz selector activity (MainActivity)
        Intent intent = getIntent();
        quiz = (Quiz) intent.getSerializableExtra("QUIZ");

        questionText = findViewById(R.id.llQuestionText);
        scoreText = findViewById(R.id.llScoreText);

        ArrayList<Answer> answers = new ArrayList<>();

        answerAdapter = new AnswerAdapter(this, 0, answers);

        ListView answerListView = findViewById(R.id.llAnswersListView);
        answerListView.setAdapter(answerAdapter);

        answerListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Answer answer = answerAdapter.getItem(i);

                boolean result = quiz.questionAnswered(answer);

                displayResult(result);

                tryNextQuestion();

            }
        });

        quiz.start();
        updateDisplay();

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

        answerAdapter.clear();
        answerAdapter.addAll(quiz.getAnswers());
        answerAdapter.notifyDataSetChanged();

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

    // Helper method that shows thumbs up or thumbs down icon
    // - Fades out both images (when the user gives rapid answers)
    // - Than fade images in and out with helper method
    private void displayResult(boolean result) {

        // Get thumb images
        ImageView thumbsUp = findViewById(R.id.llThumbsUp);
        ImageView thumbsDown = findViewById(R.id.llThumbsDown);

        // Fade them out
        fadeOut(thumbsUp);
        fadeOut(thumbsDown);

        // Call fade method for correct thumb image
        if (result) {
            fadeInAndOut(thumbsUp);

        } else {
            fadeInAndOut(thumbsDown);

        }

    }

    // Fades an image onto the screen, and after 1 second fades it back out (slow)
    private void fadeInAndOut(ImageView imageView) {

        final ImageView toFadeOut = imageView;

        imageView.animate().alpha(1.0f).setDuration(300);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                toFadeOut.animate().alpha(0.0f).setDuration(300);

            }
        }, 750);

    }
    // Fades out an image (fast)
    private void fadeOut(ImageView imageView) {
        imageView.animate().alpha(0.0f).setDuration(50);

    }

}
