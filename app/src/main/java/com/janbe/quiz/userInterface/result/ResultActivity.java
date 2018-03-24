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

/**
 * Created by janbe on 08-Mar-18.
 */

public class ResultActivity extends AppCompatActivity implements Serializable {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Starting activity & setting layout
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // Get result information from intent
        Intent intent = getIntent();
        Result result = (Result) intent.getSerializableExtra("FEEDBACK");

        Score score = result.getScore();

        TextView scoreText = (TextView) findViewById(R.id.rScoreText);
        scoreText.setText(score.getScore());

        TextView totalQuestions = (TextView) findViewById(R.id.rTotalQuestionsText);
        totalQuestions.setText(score.getTotalAnswers() + "");

        TextView answeredCorrectly = (TextView) findViewById(R.id.rAnsweredCorrectlyText);
        answeredCorrectly.setText(score.getGoodAnswers() + "");

        Button okButton = (Button) findViewById(R.id.rOkButton);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

}
