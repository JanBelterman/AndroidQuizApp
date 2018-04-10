package com.janbe.quiz.logic.quiz.questionAnswerManager;

import com.janbe.quiz.dataAcces.factory.RepositoryFactory;
import com.janbe.quiz.dataAcces.repositories.question.QuestionRepository;
import com.janbe.quiz.domain.Subject;
import com.janbe.quiz.domain.answer.Answer;
import com.janbe.quiz.domain.question.Question;

import java.util.ArrayList;
import java.util.Collections;

public class MultipleChoiceSpecificQuestionAnswerManager implements QuestionAnswerManager {

    // Data source
    private RepositoryFactory repositoryFactory;
    // Lists with question
    private ArrayList<Question> questions;

    // SET-UP
    //////////////////////////////////////////////////////////////////////////////////////////

    MultipleChoiceSpecificQuestionAnswerManager(RepositoryFactory repositoryFactory) {
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

    }

    // GET QUESTION AND ANSWERS
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

        Question question = getQuestion(questionIndex);
        ArrayList<Answer> answers = new ArrayList<>();

        answers.add(question.getRightAnswer());
        answers.addAll(question.getWrongAnswers());

        Collections.shuffle(answers);
        return answers;

    }

}
