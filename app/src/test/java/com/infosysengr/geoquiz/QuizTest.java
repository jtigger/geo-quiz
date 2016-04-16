package com.infosysengr.geoquiz;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class QuizTest {
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

    @Test
    public void currentQuestion_onInit_returnsFirstQuestion() {
        when(questionBank.nextQuestion()).thenReturn(firstQuestion);

        Quiz quiz = new Quiz(questionBank);

        assertThat(quiz.getCurrentQuestion(), equalTo(firstQuestion));
    }

    @Test
    public void currentQuestion_calledMultipleTimes_returnsTheSameQuestion() {
        when(questionBank.nextQuestion()).thenReturn(
                firstQuestion,
                secondQuestion);

        Quiz quiz = new Quiz(questionBank);

        assertThat(quiz.getCurrentQuestion(), equalTo(firstQuestion));
        assertThat(quiz.getCurrentQuestion(), equalTo(firstQuestion));
    }

    @Test
    public void answerQuestion_whenAnswerIsCorrect_returnsTrue() {
        Question question = new Question(0, true);
        when(questionBank.nextQuestion()).thenReturn(question);

        Quiz quiz = new Quiz(questionBank);

        assertThat(quiz.answerQuestion(Answer.TRUE), is(true));
    }

    @Test
    public void answerQuestion_whenAnswerIsIncorrect_returnsFalse() {
        when(questionBank.nextQuestion()).thenReturn(anyQuestion);

        Quiz quiz = new Quiz(questionBank);

        assertThat(quiz.answerQuestion(Answer.FALSE), is(false));
    }

    @Test
    public void answerQuestion_setsTheNewCurrentQuestion() {
        when(questionBank.nextQuestion()).thenReturn(
                firstQuestion,
                secondQuestion);

        Quiz quiz = new Quiz(questionBank);

        quiz.answerQuestion(Answer.TRUE);
        assertThat(quiz.getCurrentQuestion(), equalTo(secondQuestion));
    }
}
