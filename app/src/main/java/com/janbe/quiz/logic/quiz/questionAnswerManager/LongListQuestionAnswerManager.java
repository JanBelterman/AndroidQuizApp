package com.janbe.quiz.logic.quiz.questionAnswerManager;

import com.janbe.quiz.data.answer.AnswerRepository;
import com.janbe.quiz.data.factory.RepositoryFactory;
import com.janbe.quiz.data.question.QuestionRepository;
import com.janbe.quiz.domain.Subject;
import com.janbe.quiz.domain.answer.Answer;
import com.janbe.quiz.domain.question.GeneralAnsweredQuestion;
import com.janbe.quiz.domain.question.Question;
import com.janbe.quiz.domain.question.QuestionType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

/**
 * Created by janbe on 21-Mar-18.
 */

public class LongListQuestionAnswerManager implements QuestionAnswerManager {

    // Data source
    private RepositoryFactory repositoryFactory;
    // Lists with question and answers
    private ArrayList<Question> questions;
    private ArrayList<Answer> answers;

    // SET-UP
    //////////////////////////////////////////////////////////////////////////////////////////

    public LongListQuestionAnswerManager(RepositoryFactory repositoryFactory) {
        this.repositoryFactory = repositoryFactory;

    }

    // Gets questions and answers from data source
    @Override
    public void setUp(int amountOfQuestions, Subject subject) {

        // Get questions, shuffle to:
        // - Get different questions every time
        // - Have different order of questions
        questions = new ArrayList<>();
        QuestionRepository questionRepository = repositoryFactory.getQuestionRepository();
        ArrayList<Question> allQuestions = questionRepository.getQuestions(subject);
        Collections.shuffle(allQuestions);

        // Only store the right amount of questions
        int i = 1;
        for (Question question : allQuestions) {
            if (i > amountOfQuestions) {
                break;
            }
            questions.add(question);
            i++;
        }

        // Get answers, only for general answered answers, also shuffle them
        answers = new ArrayList<>();
        if (isGeneralQuestion()) {

            // Get answers
            AnswerRepository answerRepository = repositoryFactory.getAnswerRepository();
            answers = answerRepository.getAnswers(subject);
            Collections.shuffle(answers);

        }

    }

    // START
    //////////////////////////////////////////////////////////////////////////////////////////

    // Returns the question for a certain index
    @Override
    public Question getQuestion(int questionIndex) {
        return questions.get(questionIndex);

    }

    // Because quiz's questions contain a long list of answers, every answers group contains all of the stored answers.
    @Override
    public ArrayList<Answer> getAnswers(int questionIndex) {

        Question question = getQuestion(questionIndex);
        ArrayList<Answer> answers = new ArrayList<>();

        // Add right answer
        answers.add(question.getRightAnswer());

        // Add remaining 3 random (false) answers
        for (Answer answer : this.answers) {

            // Checks if answer is duplicate
            if (answers.contains(answer)) {
                continue;
            }
            // Add answer if its not a duplicate
            answers.add(answer);

        }

        // Questions need to be found easily, so the list is sorted on alphabet
        return sortAnswersViaAlphabet(answers);

    }

    // SMALL HELPER METHODS
    //////////////////////////////////////////////////////////////////////////////////////////

    // Returns is question at certain index is general question
    private boolean isGeneralQuestion() {
        return getQuestion(0).getQuestionType() == QuestionType.GENERAL_ANSWERED_QUESTION;

    }

    private ArrayList<Answer> sortAnswersViaAlphabet(ArrayList<Answer> answers) {

        Collections.sort(answers, new Comparator<Answer>() {
            @Override
            public int compare(Answer answer1, Answer answer2) {
                return answer1.getAnswer().compareTo(answer2.getAnswer());
            }
        });

        return answers;

    }

}
