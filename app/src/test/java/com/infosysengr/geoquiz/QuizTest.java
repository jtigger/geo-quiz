package com.infosysengr.geoquiz;

import org.junit.Ignore;
import org.junit.Test;

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
    public void answerQuestion_whenAnswerIsCorrect_returnsTrue() {
        QuestionBank questionBank = mock(QuestionBank.class);
        Question question = new Question(0, true);
        when(questionBank.nextQuestion()).thenReturn(question);

        Quiz quiz = new Quiz(questionBank);

        assertThat(quiz.answerQuestion(Answer.TRUE), is(true));
    }

    @Test
    public void answerQuestion_whenAnswerIsIncorrect_returnsFalse() {
        QuestionBank questionBank = mock(QuestionBank.class);
        Question question = new Question(0, true);
        when(questionBank.nextQuestion()).thenReturn(question);

        Quiz quiz = new Quiz(questionBank);

        assertThat(quiz.answerQuestion(Answer.FALSE), is(false));
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

        quiz.answerQuestion(Answer.TRUE);
        assertThat(quiz.getCurrentQuestion(), equalTo(secondQuestion));
    }
}
