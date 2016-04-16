package com.infosysengr.geoquiz;

import org.junit.Ignore;
import org.junit.Test;

import static com.infosysengr.geoquiz.Answer.TRUE;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class QuizTest {

    @Test
    public void currentQuestion_onInit_returnsFirstQuestion() {
        QuestionBank questionBank = mock(QuestionBank.class);
        Question firstQuestion = mock(Question.class, "firstQuestion");
        when(questionBank.nextQuestion()).thenReturn(firstQuestion);

        Quiz quiz = new Quiz(questionBank);

        assertThat(quiz.getCurrentQuestion(), equalTo(firstQuestion));
    }

    @Test
    public void currentQuestion_calledMultipleTimes_returnsTheSameQuestion() {
        QuestionBank questionBank = mock(QuestionBank.class);
        Question firstQuestion = mock(Question.class, "firstQuestion");
        Question secondQuestion = mock(Question.class, "secondQuestion");
        when(questionBank.nextQuestion()).thenReturn(
                firstQuestion,
                secondQuestion);

        Quiz quiz = new Quiz(questionBank);

        assertThat(quiz.getCurrentQuestion(), equalTo(firstQuestion));
        assertThat(quiz.getCurrentQuestion(), equalTo(firstQuestion));
    }

    @Test
    public void answerQuestion_returnsTheNextQuestionFromTheQuestionBank() {
        QuestionBank questionBank = mock(QuestionBank.class);
        Question firstQuestion = mock(Question.class, "firstQuestion");
        Question secondQuestion = mock(Question.class, "secondQuestion");
        when(questionBank.nextQuestion()).thenReturn(
                firstQuestion,
                secondQuestion);

        Quiz quiz = new Quiz(questionBank);

        assertThat(quiz.getCurrentQuestion(), equalTo(firstQuestion));
        assertThat(quiz.answerQuestion(TRUE), equalTo(secondQuestion));
    }

    @Test
    public void answerQuestion_setsTheNewCurrentQuestion() {
        QuestionBank questionBank = mock(QuestionBank.class);
        Question firstQuestion = mock(Question.class, "firstQuestion");
        Question secondQuestion = mock(Question.class, "secondQuestion");
        when(questionBank.nextQuestion()).thenReturn(
                firstQuestion,
                secondQuestion);

        Quiz quiz = new Quiz(questionBank);

        assertThat(quiz.answerQuestion(TRUE), equalTo(secondQuestion));
        assertThat(quiz.getCurrentQuestion(), equalTo(secondQuestion));
    }
}
