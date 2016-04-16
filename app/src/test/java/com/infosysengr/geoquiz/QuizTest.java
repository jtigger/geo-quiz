package com.infosysengr.geoquiz;

import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class QuizTest {

    @Test public void currentQuestion_onInit_returnsAQuestion() {
        QuestionBank questionBank = mock(QuestionBank.class);
        Question firstQuestion = mock(Question.class);
        when(questionBank.nextQuestion()).thenReturn(firstQuestion);

        Quiz quiz = new Quiz(questionBank);

        assertThat(quiz.currentQuestion(), equalTo(firstQuestion));
    }

    @Ignore @Test public void currentQuestion_calledMultipleTimes_returnsTheSameQuestion() {}

    @Ignore @Test public void nextQuestion_returnsTheNextQuestionFromTheQuestionBank() {}
    @Ignore @Test public void nextQuestion_setsTheNewCurrentQuestion() {}
    @Ignore @Test public void nextQuestion_whenExhaustsQuestionBank_startsOver() {}
}
