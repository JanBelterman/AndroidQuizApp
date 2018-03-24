package com.janbe.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.janbe.quiz.userInterface.settings.SettingsActivity;
import com.janbe.quiz.logic.settings.QuizSetting;
import com.janbe.quiz.logic.settings.QuizSettings;
import com.janbe.quiz.data.factory.HardCodeRepositoryFactory;
import com.janbe.quiz.domain.Subject;

public class MainActivity extends AppCompatActivity {

    private QuizSettings quizSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Super constructor and content view
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Default settings
        quizSettings = new QuizSettings(QuizSetting.SETTING_QUIZ_MULTIPLE_CHOICE,
                Subject.CAPITAL_CITIES,
                10,
                QuizSetting.SETTING_SCORE_RATIO_SCORE);

        Button customizeButton = (Button) findViewById(R.id.maSettingsButton);
        customizeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                intent.putExtra("QUIZ_SETTINGS", quizSettings);
                startActivityForResult(intent, 1);

            }
        });

        Button startButton = (Button) findViewById(R.id.maStartButton);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            if (quizSettings == null) {
                Toast.makeText(MainActivity.this, "Customize quiz first", Toast.LENGTH_SHORT).show();

            } else {
                // Start quiz
                Intent intent = new Intent(MainActivity.this, quizSettings.getQuizScreen());
                intent.putExtra("QUIZ", quizSettings.createQuiz(new HardCodeRepositoryFactory()));
                startActivity(intent);

            }

            }
        });

        // Display settings
        updateDisplayedSettings();

    }

    // Launches when customization activity is closed, store quiz settings
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {

            if (data != null) { // With back button user can parse null
                quizSettings = (QuizSettings) data.getExtras().getSerializable("QUIZ_SETTINGS");

            }

        }

        updateDisplayedSettings();

    }

    private void updateDisplayedSettings() {

        TextView quizTypeText = (TextView) findViewById(R.id.maTypeText);
        TextView subjectText = (TextView) findViewById(R.id.maSubjectText);
        TextView amountOfQuestionsText = (TextView) findViewById(R.id.maAmountText);
        TextView scoreTypeText = (TextView) findViewById(R.id.maScoreTypeText);

        quizTypeText.setText(quizSettings.getQuizType().getDescription());
        subjectText.setText(quizSettings.getSubject().getDescription());
        amountOfQuestionsText.setText(String.valueOf(quizSettings.getAmountOfQuestions()));
        scoreTypeText.setText(quizSettings.getScoreType().getDescription());

    }

}
