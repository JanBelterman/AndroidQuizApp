package com.janbe.quiz.userInterface.settings;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.janbe.quiz.R;
import com.janbe.quiz.domain.Subject;
import com.janbe.quiz.logic.settings.QuizSetting;
import com.janbe.quiz.logic.settings.QuizSettings;

import java.util.ArrayList;
import java.util.List;

public class SettingsActivity extends AppCompatActivity {

    private QuizSettings quizSettings;

    private CheckBox multipleChoiceBox;
    private CheckBox longListBox;
    private CheckBox timedScoreBox;
    private CheckBox ratioCheckBox;
    private CheckBox streakCheckBox;

    private SeekBar amountOfQuestionsSeekBar;
    private Spinner subjectSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        // quizSettings creates type of quiz according to user input
        quizSettings = (QuizSettings) getIntent().getSerializableExtra("SETTINGS");

        // Create check boxes, control the quiz type, score type and feedback type
        createCheckBoxes();
        // Create seekBar, controls the amount of questions
        createSeekBar();
        // Create spinner, controls the quiz subject
        createSpinner();
        // Create the ok button, which will launch the quiz according to user selected preferences
        createOkButton();

        displaySettings();

    }

    private void displaySettings() {

        if (quizSettings.getQuizType() == QuizSetting.SETTING_QUIZ_MULTIPLE_CHOICE) {
            multipleChoiceBox.toggle();

        } else {
            longListBox.toggle();

        }

        if (quizSettings.getSubject() == Subject.CAPITAL_CITIES) {
            subjectSpinner.setSelection(0);

        } else if (quizSettings.getSubject() == Subject.COMPUTER_SCIENCE) {
            subjectSpinner.setSelection(1);

        } else {
            subjectSpinner.setSelection(2);

        }

        if (quizSettings.getScoreType() == QuizSetting.SETTING_SCORE_RATIO_SCORE) {
            ratioCheckBox.toggle();

        } else if (quizSettings.getScoreType() == QuizSetting.SETTING_SCORE_TIMED_SCORE) {
            timedScoreBox.toggle();

        } else {
            streakCheckBox.toggle();

        }

        // Set seekBar progress and display
        amountOfQuestionsSeekBar.setProgress((quizSettings.getAmountOfQuestions() / 5) - 1);
        TextView amountOfQuestionsText = findViewById(R.id.sAmountText);
        amountOfQuestionsText.setText(String.valueOf(quizSettings.getAmountOfQuestions()));

    }

    // Creates all check boxes, controlling the quiz type, score type and feedback type
    private void createCheckBoxes() {

        // CheckBoxes, when checkBox is clicked the listener will:
        //  - deselect contradictory checkBox
        //  - pass clicked option to quizSettings, which stores that option
        multipleChoiceBox = findViewById(R.id.sMultipleChoiceBox);
        multipleChoiceBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b && longListBox.isChecked()) {
                    longListBox.toggle();
                }
                quizSettings.setQuizType(QuizSetting.SETTING_QUIZ_MULTIPLE_CHOICE);
            }
        });
        longListBox = findViewById(R.id.sLongListBox);
        longListBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b && multipleChoiceBox.isChecked()) {
                    multipleChoiceBox.toggle();

                }
                quizSettings.setQuizType(QuizSetting.SETTING_QUIZ_LONG_LIST);
            }
        });
        timedScoreBox = findViewById(R.id.sTimedScoreBox);
        timedScoreBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    if (ratioCheckBox.isChecked()) {
                        ratioCheckBox.toggle();

                    } if (streakCheckBox.isChecked()) {
                        streakCheckBox.toggle();

                    }
                }
                quizSettings.setScore(QuizSetting.SETTING_SCORE_TIMED_SCORE);
            }
        });
        ratioCheckBox = findViewById(R.id.sRatioScoreBox);
        ratioCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    if (timedScoreBox.isChecked()) {
                        timedScoreBox.toggle();

                    } if (streakCheckBox.isChecked()) {
                        streakCheckBox.toggle();

                    }
                }
                quizSettings.setScore(QuizSetting.SETTING_SCORE_RATIO_SCORE);
            }
        });
        streakCheckBox = findViewById(R.id.sStreakScoreBox);
        streakCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    if (timedScoreBox.isChecked()) {
                        timedScoreBox.toggle();

                    } if (ratioCheckBox.isChecked()) {
                        ratioCheckBox.toggle();

                    }
                }
                quizSettings.setScore(QuizSetting.SETTING_SCORE_STREAK_SCORE);
            }
        });

    }

    // Creates the seekBar, controls the amount of questions the quiz contains
    private void createSeekBar() {

        // SeekBar, controls the amount of questions in the quiz
        // Minimum 5 questions, maximum 20 questions
        amountOfQuestionsSeekBar = findViewById(R.id.sAmountBar);
        amountOfQuestionsSeekBar.setMax(5);
        amountOfQuestionsSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int progress = (i + 1) * 5;
                TextView amountOfQuestionsText = findViewById(R.id.sAmountText);
                amountOfQuestionsText.setText(String.valueOf(progress));
                quizSettings.setAmountOfQuestions(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

        });

    }

    // Creates the spinner, controls the quiz's subject
    private void createSpinner() {

        // Create spinner
        subjectSpinner = findViewById(R.id.sSubjectSpinner);

        // Create subject options
        final List<String> subjectList = new ArrayList<>();
        subjectList.add(getString(Subject.CAPITAL_CITIES.getDescription()));
        subjectList.add(getString(Subject.COMPUTER_SCIENCE.getDescription()));
        subjectList.add(getString(Subject.MATHS.getDescription()));

        // Create adapter and link to spinner
        // Long list quiz only available for general answered questions, so when for example computer science or maths is chosen
        // - long list quiz will be automatically changed into multiple choice quiz
        // - an error message will be show to the user
        ArrayAdapter<String> subjectAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, subjectList);
        subjectAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        subjectSpinner.setAdapter(subjectAdapter);

        subjectSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                String subject = subjectList.get(i);

                if (subject.equals(getString(Subject.CAPITAL_CITIES.getDescription()))) {
                    quizSettings.setSubject(Subject.CAPITAL_CITIES);
                    longListBox.setEnabled(Subject.CAPITAL_CITIES.isGeneralQuestion());

                } else if (subject.equals(getString(Subject.COMPUTER_SCIENCE.getDescription()))) {
                    quizSettings.setSubject(Subject.COMPUTER_SCIENCE);
                    if (longListBox.isChecked()) {
                        multipleChoiceBox.toggle();
                        showError(R.string.long_list_quiz_not_available + " " + subject);
                    }
                    longListBox.setEnabled(Subject.COMPUTER_SCIENCE.isGeneralQuestion());

                } else if (subject.equals(getString(Subject.MATHS.getDescription()))) {
                    quizSettings.setSubject(Subject.MATHS);
                    if (longListBox.isChecked()) {
                        multipleChoiceBox.toggle();
                        showError(R.string.long_list_quiz_not_available + " " + subject);
                    }
                    longListBox.setEnabled(Subject.MATHS.isGeneralQuestion());

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

        });

    }

    // Creates the ok button, which will use the quiz selector object to create the quiz according to user inputted preferences
    private void createOkButton() {

        // First it will check if every checkBox group has an option selected, if not it will alert the user
        // Secondly it will ask the quizSettings to create a quiz according to by the user selected options
        // Finally it will return the quiz to the main method
        Button okButton = findViewById(R.id.sSaveButton);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!allOptionsChecked()) {
                    return;

                }

                Intent intent = new Intent();
                intent.putExtra("SETTINGS", quizSettings);
                setResult(1, intent);
                finish();

                // Store settings to device data
                SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                Gson gson = new Gson();
                String json = gson.toJson(quizSettings);
                editor.putString("SETTINGS", json);
                editor.apply();

            }
        });

    }

    // Helper method that check if all checkBox group has an option selected
    private boolean allOptionsChecked() {

        if (!quizSelected()) {
            showError(getString(R.string.selectAQuizType));
            return false;

        } else if (!scoreSelected()) {
            showError(getString(R.string.selectAScoreType));
            return false;

        }

        return true;

    }
    // Helper methods that check if a checkBox group has an option selected
    private boolean quizSelected() {
        return longListBox.isChecked() || multipleChoiceBox.isChecked();

    }
    private boolean scoreSelected() {
        return ratioCheckBox.isChecked() || timedScoreBox.isChecked() || streakCheckBox.isChecked();

    }

    // Helper method to show a toast error to the user
    private void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();

    }

}
