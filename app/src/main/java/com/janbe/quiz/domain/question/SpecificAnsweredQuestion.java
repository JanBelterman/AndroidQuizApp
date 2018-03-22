package com.janbe.quiz.domain.question;

import com.janbe.quiz.domain.answer.Answer;
import com.janbe.quiz.domain.explanation.Explanation;

import java.util.ArrayList;

/**
 * Created by janbe on 10-Mar-18.
 */

public class SpecificAnsweredQuestion implements Question {
    private static final QuestionType questionType = QuestionType.SPECIFIC_ANSWERED_QUESTION;

    private String question;
    private Answer rightAnswer;
    private ArrayList<Answer> wrongAnswers;
    private Explanation explanation;

    public SpecificAnsweredQuestion(String question,
                                    Answer rightAnswer,
                                    Answer wrongAnswer1,
                                    Answer wrongAnswer2,
                                    Answer wrongAnswer3,
                                    Explanation explanation) {

        this.question = question;
        this.rightAnswer = rightAnswer;
        this.wrongAnswers = new ArrayList<>();
        this.wrongAnswers.add(wrongAnswer1);
        this.wrongAnswers.add(wrongAnswer2);
        this.wrongAnswers.add(wrongAnswer3);
        this.explanation = explanation;

    }

    @Override
    public QuestionType getQuestionType() {
        return questionType;

    }

    @Override
    public String getQuestion() {
        return question;

    }

    @Override
    public Answer getRightAnswer() {
        return rightAnswer;

    }

    @Override
    public ArrayList<Answer> getWrongAnswers() {
        return wrongAnswers;

    }

    @Override
    public Explanation getExplanation() {
        return explanation;

    }

}
