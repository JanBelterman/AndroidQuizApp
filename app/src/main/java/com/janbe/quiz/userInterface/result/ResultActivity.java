package com.janbe.quiz.userInterface.result;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.janbe.quiz.R;
import com.janbe.quiz.logic.quiz.result.Result;
import com.janbe.quiz.logic.quiz.score.Score;

import java.io.Serializable;

public class ResultActivity extends AppCompatActivity implements Serializable {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Starting activity & setting layout
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // Get result information from intent
        Intent intent = getIntent();
        Result result = (Result) intent.getSerializableExtra("RESULT");

        Score score = result.getScore();

        TextView scoreText = findViewById(R.id.rScoreText);
        scoreText.setText(score.getScore());

        TextView totalQuestions = findViewById(R.id.rTotalQuestionsText);
        totalQuestions.setText(String.valueOf(score.getTotalAnswers()));

        TextView answeredCorrectly = findViewById(R.id.rAnsweredCorrectlyText);
        answeredCorrectly.setText(String.valueOf(score.getGoodAnswers()));

        Button okButton = findViewById(R.id.rOkButton);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

}
