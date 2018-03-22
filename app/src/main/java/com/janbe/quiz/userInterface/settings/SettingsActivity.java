package com.janbe.quiz.userInterface.settings;

import android.content.Intent;
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

import com.janbe.quiz.R;
import com.janbe.quiz.domain.Subject;
import com.janbe.quiz.logic.settings.QuizSetting;
import com.janbe.quiz.logic.settings.QuizSettings;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by janbe on 14-Mar-18.
 */

public class SettingsActivity extends AppCompatActivity {

    private QuizSettings quizSettings;

    private CheckBox multipleChoiceBox;
    private CheckBox longListBox;
    private CheckBox timedScoreBox;
    private CheckBox ratioCheckBox;

    private SeekBar amountOfQuestionsSeekBar;
    private Spinner subjectSpinner;

    private Button okButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        // quizSettings creates type of quiz according to user input
        quizSettings = (QuizSettings) getIntent().getSerializableExtra("QUIZ_SETTINGS");

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

        } else {
            timedScoreBox.toggle();

        }

        // Set seekBar progress and display
        amountOfQuestionsSeekBar.setProgress((quizSettings.getAmountOfQuestions() / 5) - 1);
        TextView amountOfQuestionsText = (TextView) findViewById(R.id.amountOfQuestionsText);
        amountOfQuestionsText.setText(String.valueOf(quizSettings.getAmountOfQuestions()));

    }

    // Creates all check boxes, controlling the quiz type, score type and feedback type
    private void createCheckBoxes() {

        // CheckBoxes, when checkBox is clicked the listener will:
        //  - deselect contradictory checkBox
        //  - pass clicked option to quizSettings, which stores that option
        multipleChoiceBox = (CheckBox) findViewById(R.id.multipleChoiceCheckBox);
        multipleChoiceBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b && longListBox.isChecked()) {
                    longListBox.toggle();
                }
                quizSettings.setQuizType(QuizSetting.SETTING_QUIZ_MULTIPLE_CHOICE);
            }
        });
        longListBox = (CheckBox) findViewById(R.id.longListCheckBox);
        longListBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b && multipleChoiceBox.isChecked()) {
                    multipleChoiceBox.toggle();

                }
                quizSettings.setQuizType(QuizSetting.SETTING_QUIZ_LONG_LIST);
            }
        });
        timedScoreBox = (CheckBox) findViewById(R.id.timedScoreCheckBox);
        timedScoreBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b && ratioCheckBox.isChecked()) {
                    ratioCheckBox.toggle();
                }
                quizSettings.setScore(QuizSetting.SETTING_SCORE_TIMED_SCORE);
            }
        });
        ratioCheckBox = (CheckBox) findViewById(R.id.ratioScoreCheckBox);
        ratioCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b && timedScoreBox.isChecked()) {
                    timedScoreBox.toggle();
                }
                quizSettings.setScore(QuizSetting.SETTING_SCORE_RATIO_SCORE);
            }
        });

    }

    // Creates the seekBar, controls the amount of questions the quiz contains
    private void createSeekBar() {

        // SeekBar, controls the amount of questions in the quiz
        // Minimum 5 questions, maximum 20 questions
        amountOfQuestionsSeekBar = (SeekBar) findViewById(R.id.amountOfQuestionsSeekBar);
        amountOfQuestionsSeekBar.setMax(5);
        amountOfQuestionsSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int progress = (i + 1) * 5;
                TextView amountOfQuestionsText = (TextView) findViewById(R.id.amountOfQuestionsText);
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
        subjectSpinner = (Spinner) findViewById(R.id.spinner);

        // Create subject options
        final List<String> subjectList = new ArrayList<>();
        subjectList.add("Capital city's");
        subjectList.add("Computer science");
        subjectList.add("Maths");

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

                if (subject.equals("Capital city's")) {
                    quizSettings.setSubject(Subject.CAPITAL_CITIES);
                    longListBox.setEnabled(true);

                } else if (subject.equals("Computer science")) {
                    quizSettings.setSubject(Subject.COMPUTER_SCIENCE);
                    if (longListBox.isChecked()) {
                        multipleChoiceBox.toggle();
                        showError("Long list quiz not available for " + subject);
                    }
                    longListBox.setEnabled(false);

                } else if (subject.equals("Maths")) {
                    quizSettings.setSubject(Subject.MATHS);
                    if (longListBox.isChecked()) {
                        multipleChoiceBox.toggle();
                        showError("Long list quiz not available for " + subject);
                    }
                    longListBox.setEnabled(false);

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
        okButton = (Button) findViewById(R.id.okButton);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!allOptionsChecked()) {
                    return;

                }

                Intent intent = new Intent();
                intent.putExtra("QUIZ_SETTINGS", quizSettings);
                setResult(1, intent);
                finish();

            }
        });

    }

    // Helper method that check if all checkBox group has an option selected
    private boolean allOptionsChecked() {

        if (!quizSelected()) {
            showError("Select a quiz type");
            return false;

        } else if (!scoreSelected()) {
            showError("Select a score type");
            return false;

        }

        return true;

    }
    // Helper methods that check if a checkBox group has an option selected
    private boolean quizSelected() {
        return longListBox.isChecked() || multipleChoiceBox.isChecked();

    }
    private boolean scoreSelected() {
        return ratioCheckBox.isChecked() || timedScoreBox.isChecked();

    }

    // Helper method to show a toast error to the user
    private void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();

    }

}
