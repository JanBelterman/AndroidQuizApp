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
import java.util.Random;

/**
 * Created by janbe on 15-Mar-18.
 */

public class MultipleChoiceQuestionAnswerManager implements QuestionAnswerManager {

    // Data source
    private RepositoryFactory repositoryFactory;
    // Lists with question and answers
    private ArrayList<Question> questions;
    private ArrayList<Answer> answers;

    // SET-UP
    //////////////////////////////////////////////////////////////////////////////////////////

    public MultipleChoiceQuestionAnswerManager(RepositoryFactory repositoryFactory) {
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
        if (isGeneralQuestion(0)) {

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

    // Because quiz is multiple choice, every answers group contains 4 answers.
    // If the questions is a specific answered question, the 4 answers are stored in the question itself.
    // But if the question is a general answered question, all answers are stored in the answer list.
    @Override
    public ArrayList<Answer> getAnswers(int questionIndex) {

        // So first check if question is general answered or specific answered and than return relevant group of answer
        // Than return equivalent group of answers
        if (isGeneralQuestion(questionIndex)) {
            return getGeneralAnswers(questionIndex);

        } else {
            return getSpecificAnswers(questionIndex);

        }

    }

    //BIG HELPER METHODS
    //////////////////////////////////////////////////////////////////////////////////////////

    private ArrayList<Answer> getGeneralAnswers(int questionIndex) {

        Question question = getQuestion(questionIndex);
        ArrayList<Answer> answers = new ArrayList<>();

        // Add right answer
        answers.add(question.getRightAnswer());

        // Add remaining 3 random (false) answers
        while (answers.size() < 4) {

            // Get random answer
            Answer answer = getRandomAnswer();
            // Checks if answer is duplicate
            if (answers.contains(answer)) {
                continue;
            }
            // Add answer if its not a duplicate
            answers.add(answer);

        }

        // Shuffle answers, otherwise the right answer would always be at index 0
        Collections.shuffle(answers);
        return answers;

    }

    private ArrayList<Answer> getSpecificAnswers(int questionIndex) {

        Question question = getQuestion(questionIndex);
        ArrayList<Answer> answers = new ArrayList<>();

        answers.add(question.getRightAnswer());
        answers.addAll(question.getWrongAnswers());

        Collections.shuffle(answers);
        return answers;

    }

    // SMALL HELPER METHODS
    //////////////////////////////////////////////////////////////////////////////////////////

    // Returns is question at certain index is general question
    private boolean isGeneralQuestion(int questionIndex) {
        return getQuestion(questionIndex).getQuestionType() == QuestionType.GENERAL_ANSWERED_QUESTION;

    }

    // Returns a random answer
    private Answer getRandomAnswer() {
        Random random = new Random();
        return answers.get(random.nextInt(answers.size() - 1));

    }

}
