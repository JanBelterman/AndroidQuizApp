package com.janbe.quiz.data.answer;

import com.janbe.quiz.domain.Subject;
import com.janbe.quiz.domain.answer.Answer;

import java.util.ArrayList;

public class HardCodeAnswerRepository implements AnswerRepository {

    @Override
    public ArrayList<Answer> getAnswers(Subject subject) {

        ArrayList<Answer> answers = new ArrayList<>();

        answers.add(new Answer("Amsterdam"));
        answers.add(new Answer("London"));
        answers.add(new Answer("Paris"));
        answers.add(new Answer("Berlin"));
        answers.add(new Answer("Brussels"));
        answers.add(new Answer("Madrid"));
        answers.add(new Answer("Lisbon"));
        answers.add(new Answer("Rome"));
        answers.add(new Answer("Vienna"));
        answers.add(new Answer("Sofia"));
        answers.add(new Answer("Zagreb"));
        answers.add(new Answer("Prague"));
        answers.add(new Answer("Copenhagen"));
        answers.add(new Answer("Helsinki"));
        answers.add(new Answer("Athens"));
        answers.add(new Answer("Budapest"));
        answers.add(new Answer("Reykjavik"));
        answers.add(new Answer("Dublin"));
        answers.add(new Answer("Luxembourg"));
        answers.add(new Answer("Skopje"));
        answers.add(new Answer("Podgorica"));
        answers.add(new Answer("Oslo"));
        answers.add(new Answer("Warsaw"));
        answers.add(new Answer("Bucharest"));
        answers.add(new Answer("Moscow"));
        answers.add(new Answer("Bratislava"));
        answers.add(new Answer("Stockholm"));
        answers.add(new Answer("Ankara"));
        answers.add(new Answer("Kiev"));

        return answers;

    }

}
