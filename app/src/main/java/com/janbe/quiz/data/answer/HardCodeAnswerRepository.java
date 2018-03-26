package com.janbe.quiz.data.answer;

import com.janbe.quiz.domain.Subject;
import com.janbe.quiz.domain.answer.Answer;

import java.util.ArrayList;

public class HardCodeAnswerRepository implements AnswerRepository {

    @Override
    public ArrayList<Answer> getAnswers(Subject subject) {

        ArrayList<Answer> answers = new ArrayList<>();

        answers.add(new Answer("Amsterdam", "Amsterdam"));
        answers.add(new Answer("London", "Londen"));
        answers.add(new Answer("Paris", "Parijs"));
        answers.add(new Answer("Berlin", "Berlijn"));
        answers.add(new Answer("Brussels", "Brussel"));
        answers.add(new Answer("Madrid", "Madrid"));
        answers.add(new Answer("Lisbon", "Lissabon"));
        answers.add(new Answer("Rome", "Rome"));
        answers.add(new Answer("Vienna", "Wenen"));
        answers.add(new Answer("Sofia", "Sofia"));
        answers.add(new Answer("Zagreb", "Zagreb"));
        answers.add(new Answer("Prague", "Praag"));
        answers.add(new Answer("Copenhagen", "Kopenhagen"));
        answers.add(new Answer("Helsinki", "Helsinki"));
        answers.add(new Answer("Athens", "Athene"));
        answers.add(new Answer("Budapest", "Boedapest"));
        answers.add(new Answer("Reykjavik", "Reykjavik"));
        answers.add(new Answer("Dublin", "Dublin"));
        answers.add(new Answer("Luxembourg", "Luxemburg"));
        answers.add(new Answer("Skopje", "Skopje"));
        answers.add(new Answer("Podgorica", "Podgorica"));
        answers.add(new Answer("Oslo", "Oslo"));
        answers.add(new Answer("Warsaw", "Warschau"));
        answers.add(new Answer("Bucharest", "Boekarest"));
        answers.add(new Answer("Moscow", "Moskou"));
        answers.add(new Answer("Bratislava", "Bratislava"));
        answers.add(new Answer("Stockholm", "Stockholm"));
        answers.add(new Answer("Ankara", "Ankara"));
        answers.add(new Answer("Kiev", "Kiev"));

        return answers;

    }

}
