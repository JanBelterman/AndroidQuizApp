package com.janbe.quiz.data.question;

import com.janbe.quiz.domain.Subject;
import com.janbe.quiz.domain.answer.Answer;
import com.janbe.quiz.domain.explanation.Explanation;
import com.janbe.quiz.domain.question.GeneralAnsweredQuestion;
import com.janbe.quiz.domain.question.Question;
import com.janbe.quiz.domain.question.SpecificAnsweredQuestion;

import java.util.ArrayList;

public class HardCodeQuestionRepository implements QuestionRepository {

    @Override
    public ArrayList<Question> getQuestions(Subject subject) {

        switch (subject) {

            case CAPITAL_CITIES: return capitalCities();

            case COMPUTER_SCIENCE: return computerScience();

            case MATHS: return maths();
        }

        throw new IllegalStateException("Subject not found");

    }

    private ArrayList<Question> capitalCities() {

        ArrayList<Question> questions = new ArrayList<>();

        questions.add(new GeneralAnsweredQuestion("What is the capital city of The Netherlands?",
                "Wat is de hoofdstad van Nederland?",
                new Answer("Amsterdam", "Amsterdam"),
                new Explanation("The capital city of The Netherlands is Amsterdam",
                        "De hoofdstad van Nederland is Amsterdam")));

        questions.add(new GeneralAnsweredQuestion("What is the capital city of England?",
                "Wat is de hoofdstad van Engeland?",
                new Answer("London", "Londen"),
                new Explanation("The capital city of England is London",
                        "De hoofdstad van Engeland is Londen")));

        questions.add(new GeneralAnsweredQuestion("What is the capital city of France?",
                "Wat is de hoofdstad van Frankrijk?",
                new Answer("Paris", "Parijs"),
                new Explanation("The capital city of France is Paris",
                        "De hoofdstad van Frankrijk is Parijs")));

        questions.add(new GeneralAnsweredQuestion("What is the capital city of Germany?",
                "Wat is de hoofdstad van Duitsland?",
                new Answer("Berlin", "Berlijn"),
                new Explanation("The capital city of Germany is Berlin",
                        "De hoofdstad van Duitsland is Berlijn")));

        questions.add(new GeneralAnsweredQuestion("What is the capital city of Belgium?",
                "Wat is de hoofdstad van België?",
                new Answer("Brussels", "Brussel"),
                new Explanation("The capital city of Belgium is Brussels",
                        "De hoofdstad van België is Brussel")));

        questions.add(new GeneralAnsweredQuestion("What is the capital city of Spain?",
                "Wat is de hoofdstad van Spanje?",
                new Answer("Madrid", "Madrid"),
                new Explanation("The capital city of Spain is Madrid",
                        "De hoofdstad van Spanje is Madrid")));

        questions.add(new GeneralAnsweredQuestion("What is the capital city of Portugal?",
                "Wat is de hoofdstad van Portugal?",
                new Answer("Lisbon", "Lissabon"),
                new Explanation("The capital city of Portugal is Lisbon",
                        "De hoofdstad van Portugal is Lissabon")));

        questions.add(new GeneralAnsweredQuestion("What is the capital city of Italy?",
                "Wat is de hoofdstad van Italië?",
                new Answer("Rome", "Rome"),
                new Explanation("The capital city of Italy is Rome",
                        "De hoofdstad van Italië is Rome")));

        questions.add(new GeneralAnsweredQuestion("What is the capital city of Austria?",
                "Wat is de hoofdstad van Oostenrijk?",
                new Answer("Vienna", "Wenen"),
                new Explanation("The capital city of Austria is Vienna",
                        "De hoofdstad van Oostenrijk is Wenen")));

        questions.add(new GeneralAnsweredQuestion("What is the capital city of Bulgaria?",
                "Wat is de hoofdstad van Bulgarije?",
                new Answer("Sofia", "Sofia"),
                new Explanation("The capital city of Bulgaria is Sofia",
                        "De hoofdstad van Bulgarije is Sofia")));

        questions.add(new GeneralAnsweredQuestion("What is the capital city of Croatia?",
                "Wat is de hoofdstad van Kroatië?",
                new Answer("Zagreb", "Zagreb"),
                new Explanation("The capital city of Croatia is Zagreb",
                        "De hoofdstad van Kroatië is Zagreb")));

        questions.add(new GeneralAnsweredQuestion("What is the capital city of The Czech Republic?",
                "Wat is de hoofdstad van Tsjechië?",
                new Answer("Prague", "Praag"),
                new Explanation("The capital city of The Czech Republic is Prague",
                        "De hoofdstad van Tsjechië is Praag")));

        questions.add(new GeneralAnsweredQuestion("What is the capital city of Denmark?",
                "Wat is de hoofdstad van Denemarken?",
                new Answer("Copenhagen", "Kopenhagen"),
                new Explanation("The capital city of Denmark is Copenhagen",
                        "De hoofdstad van Denemarken is Kopenhagen")));

        questions.add(new GeneralAnsweredQuestion("What is the capital city of Finland?",
                "Wat is de hoofdstad van Finland?",
                new Answer("Helsinki", "Helsinki"),
                new Explanation("The capital city of Finland is Helsinki",
                        "De hoofdstad van Finland is Helsinki")));

        questions.add(new GeneralAnsweredQuestion("What is the capital city of Greece?",
                "Wat is de hoofdstad van Griekenland?",
                new Answer("Athens", "Athene"),
                new Explanation("The capital city of Greece is Athens",
                        "De hoofdstad van Griekenland is Athene")));

        questions.add(new GeneralAnsweredQuestion("What is the capital city of Hungary?",
                "Wat is de hoofdstad van Hongarije?",
                new Answer("Budapest", "Boedapest"),
                new Explanation("The capital city of Hungary is Budapest",
                        "De hoofdstad van Hongarije is Boedapest")));

        questions.add(new GeneralAnsweredQuestion("What is the capital city of Iceland?",
                "Wat is de hoofdstad van IJsland?",
                new Answer("Reykjavik", "Reykjavik"),
                new Explanation("The capital city of Iceland is Reykjavik",
                        "De hoofdstad van IJsland is Reykjavik")));

        questions.add(new GeneralAnsweredQuestion("What is the capital city of Ireland?",
                "Wat is de hoofdstad van Ierland?",
                new Answer("Dublin", "Dublin"),
                new Explanation("The capital city of Ireland is Dublin",
                        "De hoofdstad van Ierland is Dublin")));

        questions.add(new GeneralAnsweredQuestion("What is the capital city of Luxembourg?",
                "Wat is de hoofdstad van Luxemburg?",
                new Answer("Luxembourg", "Luxemburg"),
                new Explanation("The capital city of Luxembourg is Luxembourg",
                        "De hoofdstad van Luxemburg is Luxemburg")));

        questions.add(new GeneralAnsweredQuestion("What is the capital city of Macedonia?",
                "Wat is de hoofdstad van Macedonië?",
                new Answer("Skopje", "Skopje"),
                new Explanation("The capital city of Macedonia is Skopje",
                        "De hoofdstad van Macedonië is Skopje")));

        questions.add(new GeneralAnsweredQuestion("What is the capital city of Montenegro?",
                "Wat is de hoofdstad van Montenegro?",
                new Answer("Podgorica", "Podgorica"),
                new Explanation("The capital city of Montenegro is Podgorica",
                        "De hoofdstad van Montenegro is Podgorica")));

        questions.add(new GeneralAnsweredQuestion("What is the capital city of Norway?",
                "Wat is de hoofdstad van Noorwegen?",
                new Answer("Oslo", "Oslo"),
                new Explanation("The capital city of Norway is Oslo",
                        "De hoofdstad van Noorwegen is Oslo")));

        questions.add(new GeneralAnsweredQuestion("What is the capital city of Poland?",
                "Wat is de hoofdstad van Polen?",
                new Answer("Warsaw", "Warschau"),
                new Explanation("The capital city of Poland is Warsaw",
                        "De hoofdstad van Polen is Warschau")));

        questions.add(new GeneralAnsweredQuestion("What is the capital city of Romania?",
                "Wat is de hoofdstad van Roemenië?",
                new Answer("Bucharest", "Boekarest"),
                new Explanation("The capital city of Romania is Bucharest",
                        "De hoofdstad van Roemenië is Boekarest")));

        questions.add(new GeneralAnsweredQuestion("What is the capital city of Russia?",
                "Wat is de hoofdstad van Rusland?",
                new Answer("Moscow", "Moskou"),
                new Explanation("The capital city of Russia is Moscow",
                        "De hoofdstad van Rusland is Moskou")));

        questions.add(new GeneralAnsweredQuestion("What is the capital city of Slovakia?",
                "Wat is de hoofdstad van Slowakije?",
                new Answer("Bratislava", "Bratislava"),
                new Explanation("The capital city of Slovakia is Bratislava",
                        "De hoofdstad van Slowakije is Bratislava")));

        questions.add(new GeneralAnsweredQuestion("What is the capital city of Sweden?",
                "Wat is de hoofdstad van Zweden?",
                new Answer("Stockholm", "Stockholm"),
                new Explanation("The capital city of Sweden is Stockholm",
                        "De hoofdstad van Zweden is Stockholm")));

        questions.add(new GeneralAnsweredQuestion("What is the capital city of Turkey?",
                "Wat is de hoofdstad van Turkije?",
                new Answer("Ankara", "Ankara"),
                new Explanation("The capital city of Turkey is Ankara",
                        "De hoofdstad van Turkije is Ankara")));

        questions.add(new GeneralAnsweredQuestion("What is the capital city of Ukraine?",
                "Wat is de hoofdstad van Oekraïne?",
                new Answer("Kiev", "Kiev"),
                new Explanation("The capital city of Ukraine is Kiev",
                        "De hoofdstad van Oekraïne is Kiev")));

        questions.add(new GeneralAnsweredQuestion("What is the capital city of Albania?",
                "Wat is de hoofdstad van Albanië?",
                new Answer("Tirana", "Tirana"),
                new Explanation("The capital city of Albania is Tirana",
                        "De hoofdstad van Albanië is Tirana")));

        return questions;

    }

    private ArrayList<Question> computerScience() {

        ArrayList<Question> questions = new ArrayList<>();

            questions.add(new SpecificAnsweredQuestion("The brain of any computer system is:",
                    "Het brein van een computer systeem is:",
                    new Answer("CPU", "Processor"),
                    new Answer("HDD", "Harde schijf"),
                    new Answer("Memory", "Geheugen"),
                    new Answer("Power supply", "Voeding"),
                    new Explanation("The brain of any computer system is the CPU (central processing unit)",
                            "Het brein van een computer systeem is de processor")));

        questions.add(new SpecificAnsweredQuestion("The binary system uses powers of:",
                "Het binaire systeem gebruikt machten van:",
                new Answer("2"),
                new Answer("4"),
                new Answer("1"),
                new Answer("16"),
                new Explanation("The binary system uses powers of 2, it consists of 0's and 1's",
                        "Het binaire systeem gebruikt machten van 2, het bestaat uit 0en en 1en")));

        questions.add(new SpecificAnsweredQuestion("A common boundary between two systems is called:",
                "Een veelvoorkomende grens tussen twee systemen is heet:",
                new Answer("Interface"),
                new Answer("Surface"),
                new Answer("Control structure"),
                new Answer("Interdiction"),
                new Explanation("A common boundrary between two systems is called an interface",
                        "Een veelvoorkomende grens tussen twee systemen heet een interface")));

        return questions;

    }

    private ArrayList<Question> maths() {

        ArrayList<Question> questions = new ArrayList<>();

            questions.add(new SpecificAnsweredQuestion("Which number does not belong in the list?\n3, 7, 15, 17, 22, 27, 29",
                    "Welke nummer hoort niet in het rijtje thuis?\n3, 7, 15, 17, 22, 27, 29",
                    new Answer("22"),
                    new Answer("15"),
                    new Answer("27"),
                    new Answer("15"),
                    new Explanation("22 does not belong in the list, because it is the only even number, the rest are odd numbers",
                            "22 hoort niet in het rijtje thuis, omdat 22 even is en alle andere nummers oneven zijn")));

        return questions;

    }

}
