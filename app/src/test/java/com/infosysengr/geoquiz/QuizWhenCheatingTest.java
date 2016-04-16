package com.infosysengr.geoquiz;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class QuizWhenCheatingTest {
    private QuestionBank questionBank;
    private Question firstQuestion;
    private Question secondQuestion;
    private Question anyQuestion;

    @Before
    public void setUp() {
        questionBank = mock(QuestionBank.class);
        firstQuestion = mock(Question.class, "firstQuestion");
        secondQuestion = mock(Question.class, "secondQuestion");
        anyQuestion = new Question(0, true);
    }

    private Quiz newQuizWithCheating() {
        Quiz quiz = new Quiz(questionBank);
        quiz.setCheating(true);

        return quiz;
    }

    @Test
    public void answerQuestion_whenAnswerIsCorrect_returnsFalse() {
        Question question = new Question(0, true);
        when(questionBank.nextQuestion()).thenReturn(question);

        Quiz quiz = newQuizWithCheating();

        assertThat(quiz.answerQuestion(Answer.TRUE), is(false));
    }

    @Test
    public void answerQuestion_whenAnswerIsIncorrect_returnsFalse() {
        when(questionBank.nextQuestion()).thenReturn(anyQuestion);

        Quiz quiz = newQuizWithCheating();

        assertThat(quiz.answerQuestion(Answer.FALSE), is(false));
    }



}
