package com.janbe.quiz.data.question;

import com.janbe.quiz.domain.Subject;
import com.janbe.quiz.domain.answer.Answer;
import com.janbe.quiz.domain.explanation.Explanation;
import com.janbe.quiz.domain.question.GeneralAnsweredQuestion;
import com.janbe.quiz.domain.question.Question;
import com.janbe.quiz.domain.question.SpecificAnsweredQuestion;

import java.util.ArrayList;

/**
 * Created by janbe on 15-Mar-18.
 */

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

        questions.add(new GeneralAnsweredQuestion("What is the capital city of The Netherlands",
                new Answer("Amsterdam"),
                new Explanation("The capital city of The Netherlands is Amsterdam")));

        questions.add(new GeneralAnsweredQuestion("What is the capital city of England?",
                new Answer("London"),
                new Explanation("The capital city of England is London")));

        questions.add(new GeneralAnsweredQuestion("What is the capital city of France?",
                new Answer("Paris"),
                new Explanation("The capital city of France is Paris")));

        questions.add(new GeneralAnsweredQuestion("What is the capital city of Germany?",
                new Answer("Berlin"),
                new Explanation("The capital city of Germany is Berlin")));

        questions.add(new GeneralAnsweredQuestion("What is the capital city of Belgium?",
                new Answer("Brussels"),
                new Explanation("The capital city of Belgium is Brussels")));

        questions.add(new GeneralAnsweredQuestion("What is the capital city of Spain?",
                new Answer("Madrid"),
                new Explanation("The capital city of Spain is Madrid")));

        questions.add(new GeneralAnsweredQuestion("What is the capital city of Portugal?",
                new Answer("Lisbon"),
                new Explanation("The capital city of Portugal is Lisbon")));

        questions.add(new GeneralAnsweredQuestion("What is the capital city of Italy?",
                new Answer("Rome"),
                new Explanation("The capital city of Italy is Rome")));

        questions.add(new GeneralAnsweredQuestion("What is the capital city of Austria?",
                new Answer("Vienna"),
                new Explanation("The capital city of Austria is Vienna")));

        questions.add(new GeneralAnsweredQuestion("What is the capital city of Bulgaria?",
                new Answer("Sofia"),
                new Explanation("The capital city of Bulgaria is Sofia")));

        questions.add(new GeneralAnsweredQuestion("What is the capital city of Croatia?",
                new Answer("Zagreb"),
                new Explanation("The capital city of Croatia is Zagreb")));

        questions.add(new GeneralAnsweredQuestion("What is the capital city of The Czech Republic?",
                new Answer("Prague"),
                new Explanation("The capital city of The Czech Republic is Prague")));

        questions.add(new GeneralAnsweredQuestion("What is the capital city of Denmark?",
                new Answer("Copenhagen"),
                new Explanation("The capital city of Denmark is Copenhagen")));

        questions.add(new GeneralAnsweredQuestion("What is the capital city of Finland?",
                new Answer("Helsinki"),
                new Explanation("The capital city of Finland is Helsinki")));

        questions.add(new GeneralAnsweredQuestion("What is the capital city of Greece?",
                new Answer("Athens"),
                new Explanation("The capital city of Greece is Athens")));

        questions.add(new GeneralAnsweredQuestion("What is the capital city of Hungary?",
                new Answer("Budapest"),
                new Explanation("The capital city of Hungary is Budapest")));

        questions.add(new GeneralAnsweredQuestion("What is the capital city of Iceland?",
                new Answer("Reykjavik"),
                new Explanation("The capital city of Iceland is Reykjavik")));

        questions.add(new GeneralAnsweredQuestion("What is the capital city of Ireland?",
                new Answer("Dublin"),
                new Explanation("The capital city of Ireland is Dublin")));

        questions.add(new GeneralAnsweredQuestion("What is the capital city of Luxembourg?",
                new Answer("Luxembourg"),
                new Explanation("The capital city of Luxembourg is Luxembourg")));

        questions.add(new GeneralAnsweredQuestion("What is the capital city of Macedonia?",
                new Answer("Skopje"),
                new Explanation("The capital city of Macedonia is Skopje")));

        questions.add(new GeneralAnsweredQuestion("What is the capital city of Montenegro?",
                new Answer("Podgorica"),
                new Explanation("The capital city of Montenegro is Podgorica")));

        questions.add(new GeneralAnsweredQuestion("What is the capital city of Norway?",
                new Answer("Oslo"),
                new Explanation("The capital city of Norway is Oslo")));

        questions.add(new GeneralAnsweredQuestion("What is the capital city of Poland?",
                new Answer("Warsaw"),
                new Explanation("The capital city of Poland is Warsaw")));

        questions.add(new GeneralAnsweredQuestion("What is the capital city of Romania?",
                new Answer("Bucharest"),
                new Explanation("The capital city of Romania is Bucharest")));

        questions.add(new GeneralAnsweredQuestion("What is the capital city of Russia?",
                new Answer("Moscow"),
                new Explanation("The capital city of Russia is Moscow")));

        questions.add(new GeneralAnsweredQuestion("What is the capital city of Slovakia?",
                new Answer("Bratislava"),
                new Explanation("The capital city of Slovakia is Bratislava")));

        questions.add(new GeneralAnsweredQuestion("What is the capital city of Sweden?",
                new Answer("Stockholm"),
                new Explanation("The capital city of Sweden is Stockholm")));

        questions.add(new GeneralAnsweredQuestion("What is the capital city of Turkey?",
                new Answer("Ankara"),
                new Explanation("The capital city of Turkey is Ankara")));

        questions.add(new GeneralAnsweredQuestion("What is the capital city of Ukraine?",
                new Answer("Kiev"),
                new Explanation("The capital city of Ukraine is Kiev")));

        return questions;

    }

    private ArrayList<Question> computerScience() {

        ArrayList<Question> questions = new ArrayList<>();

        questions.add(new SpecificAnsweredQuestion("What was originally called the \"imitation game\" by its creator?",
                new Answer("The Turing Test"),
                new Answer("The Logic Theorist"),
                new Answer("Cybernetics"),
                new Answer("LISP"),
                new Explanation("")));
        questions.add(new SpecificAnsweredQuestion("There are 25 horses. What is the minimum number of races needed so you can identify the fastest 3 horses? You can race up to 5 horses at a time, but you do not have a watch.",
                new Answer("7"),
                new Answer("9"),
                new Answer("6"),
                new Answer("10"),
                new Explanation("")));
        questions.add(new SpecificAnsweredQuestion("In windows a folder cannot be named:",
                new Answer("con"),
                new Answer("del"),
                new Answer("sys"),
                new Answer("bin"),
                new Explanation("")));
        questions.add(new SpecificAnsweredQuestion("A computer program that converts assembly language to machine language is:",
                new Answer("Assembler"),
                new Answer("Compiler"),
                new Answer("Interpreter"),
                new Answer("Comparator"),
                new Explanation("")));

        return questions;

    }

    private ArrayList<Question> maths() {

        ArrayList<Question> questions = new ArrayList<>();

        questions.add(new SpecificAnsweredQuestion("For each triple of numbers (a, b, c) a \"next\" triple of numbers (formula: b + c, c + a, a + b) was created. This was called an \"operation\". 2004 of such operations were made starting with numbers (1, 3, 5), and resulting with numbers (x, y, z)." +
                "\n" + "Which is the difference of x - y?",
                new Answer("-2"),
                new Answer("2"),
                new Answer("2004"),
                new Answer("4008"),
                new Explanation("The first few triples are:\n" +
                        "\n" +
                        "(1, 3, 5), (8, 6, 4), (10, 12, 14), (26, 24, 22) etc\n" +
                        "\n" +
                        "The difference between the first number and the second number in each triple is:\n" +
                        "\n" +
                        "-2, 2, -2, 2, -2 etc\n" +
                        "\n" +
                        "That is -2 for each even time the operation is performed and 2 for each odd time the operation is performed.\n" +
                        "\n" +
                        "2004 is even\n" +
                        "So, if 2004 such operations resulted with numbers (x, y, z), then x - y = -2.")));
        questions.add(new SpecificAnsweredQuestion("2004 is divisible by 12 and the sum of its digits is equal to 6. \n" +
                "\n" +
                "Altogether, how many four-digit numbers have these two properties?",
                new Answer("18"),
                new Answer("10"),
                new Answer("16"),
                new Answer("19"),
                new Explanation("It must be even to be divisible by 12\n" +
                        "\n" +
                        "And the digits must add to 6, and at least one must be even (to be the units digit), so the digits must be (not in any order yet):\n" +
                        "{0,0,0,6}, {0,0,1,5}, {0,0,2,4}, {0,1,1,4}, {0,0,3,3}, {0,1,2,3}, {0,2,2,2} or {1,1,2,2}\n" +
                        "\n" +
                        "{0,0,0,6} makes only 6000\n" +
                        "{0,0,1,5} makes these even numbers: 1050, 1500, 5010 and 5100\n" +
                        "{0,0,2,4} makes these even numbers: 2004, 2040, 2400, 4002, 4020 and 4200\n" +
                        "{0,1,1,4} makes these even numbers: 1014, 1104, 1140 and 4110\n" +
                        "{0,0,3,3} makes these even numbers: 3300, 3030\n" +
                        "{0,1,2,3} makes these even numbers: 1032, 1230, 1302, 1320, 3012, 3102 and 3120\n" +
                        "{0,2,2,2} makes these even numbers: 2220, 2202 and 2022\n" +
                        "{1,1,2,2} makes these even numbers: 1122, 1212 and 2112\n" +
                        "\n" +
                        "Of the numbers listed above, the following are divisible by 12:\n" +
                        "6000, 1500, 5100, 2004, 2040, 2400, 4020, 4200, 1104, 1140, 3300, 1032, 1320, 3012, 3120, 2220, 1212 and 2112\n" +
                        "\n" +
                        "There are 18 of them.")));
        questions.add(new SpecificAnsweredQuestion("How many natural numbers n have the property that the remainder of dividing 2003 by n is equal to 23?",
                new Answer("22"),
                new Answer("21"),
                new Answer("35"),
                new Answer("36"),
                new Explanation("If 2003 is divided by n, the result would be a whole number N plus a remainder. \n" +
                        "If the remainder is 23, then:\n" +
                        "\\frac{2003}{n}=N+\\frac{23}{n}\\\\\\\\\\RightarrowN=\\frac{1980}{n}\\\\\\\\\\Rightarrown=\\frac{1980}{N}\n" +
                        "\n" +
                        "So we need to find the factors of 1980\n" +
                        "These are: 1, 2, 3, 4, 5, 6, 9, 10, 11, 12, 15, 18, 20, 22, 30, 33, 36, 44, 45, 55, 60, 66, 90, 99, 110, 132, 165, 180, 198, 220, 330, 396, 495, 660, 990 and 1980\n" +
                        "\n" +
                        "However, n must be greater than 23; otherwise the remainder cannot be 23.\n" +
                        "\n" +
                        "So, there are 22 possible values of n: 30, 33, 36, 44, 45, 55, 60, 66, 90, 99, 110, 132, 165, 180, 198, 220, 330, 396, 495, 660, 990 and 1980")));

        return questions;

    }

}
