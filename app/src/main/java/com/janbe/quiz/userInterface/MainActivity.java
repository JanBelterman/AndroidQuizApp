package com.janbe.quiz.userInterface;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.janbe.quiz.R;
import com.janbe.quiz.userInterface.settings.SettingsActivity;
import com.janbe.quiz.logic.settings.QuizSetting;
import com.janbe.quiz.logic.settings.QuizSettings;
import com.janbe.quiz.data.factory.HardCodeRepositoryFactory;
import com.janbe.quiz.domain.Subject;

import java.lang.reflect.Type;

public class MainActivity extends AppCompatActivity {

    private QuizSettings quizSettings;

    // Menu stuff (settings)
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_activity_bar, menu);

        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.menuSettings) {
            Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
            intent.putExtra("SETTINGS", quizSettings);
            startActivityForResult(intent, 1);

        }

        return super.onOptionsItemSelected(item);

    }

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

        //Get stored settings
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("SETTINGS", null);
        Type type = new TypeToken<QuizSettings>(){}.getType();
        QuizSettings storedSettings = gson.fromJson(json, type);

        if (storedSettings != null) {
            quizSettings = storedSettings;

        }

        Button startButton = findViewById(R.id.maStartButton);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Start quiz
                Intent intent = new Intent(MainActivity.this, quizSettings.getQuizScreen());
                intent.putExtra("QUIZ", quizSettings.createQuiz(new HardCodeRepositoryFactory()));
                startActivity(intent);

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
                if (data.getExtras() != null) {
                    quizSettings = (QuizSettings) data.getExtras().getSerializable("SETTINGS");

                }

            }

        }

        updateDisplayedSettings();

    }

    private void updateDisplayedSettings() {

        TextView quizTypeText = findViewById(R.id.maTypeText);
        TextView subjectText = findViewById(R.id.maSubjectText);
        TextView amountOfQuestionsText = findViewById(R.id.maAmountText);
        TextView scoreTypeText = findViewById(R.id.maScoreTypeText);

        quizTypeText.setText(quizSettings.getQuizType().getDescription());
        subjectText.setText(quizSettings.getSubject().getDescription());
        amountOfQuestionsText.setText(String.valueOf(quizSettings.getAmountOfQuestions()));
        scoreTypeText.setText(quizSettings.getScoreType().getDescription());

    }

}
