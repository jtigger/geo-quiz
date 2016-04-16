package com.infosysengr.geoquiz;

import android.widget.Button;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class AnswerActuatorTest {
    private Button trueButton;
    private Button falseButton;
    private Button maybeButton;
    private Quiz quiz;
    private QuizListener quizListener;

    private AnswerActuator answerActuator;

    @Before
    public void setUp() {
        trueButton = mock(Button.class);
        falseButton = mock(Button.class);
        maybeButton = mock(Button.class);
        quiz = mock(Quiz.class);
        quizListener = mock(QuizListener.class);
        answerActuator = new AnswerActuator(trueButton, falseButton, maybeButton, quiz, quizListener);
    }

    @Test
    public void onClick_fromMaybeButton_triggersSkippedQuestionEvent() {
        answerActuator.onClick(maybeButton);
        verify(quizListener).skippedQuestion();
    }

    @Test
    public void onClick_fromMaybeButton_answersTheCurrentQuestionAsMaybe() {
        answerActuator.onClick(maybeButton);
        verify(quiz).answerQuestion(Answer.MAYBE);
    }

    @Test
    public void onClick_fromTrueButton_answersTheCurrentQuestionAsTrue() {
        answerActuator.onClick(trueButton);
        verify(quiz).answerQuestion(Answer.TRUE);
    }

    @Test
    public void onClick_fromFalseButton_answersTheCurrentQuestionAsFalse() {
        answerActuator.onClick(falseButton);
        verify(quiz).answerQuestion(Answer.FALSE);
    }

    @Test
    public void onClick_whenGuessIsCorrect_triggersAnsweredCorrectlyEvent() {
        when(quiz.answerQuestion(any(Answer.class))).thenReturn(true);
        answerActuator.onClick(trueButton);
        verify(quizListener).answeredCorrectly();
    }

    @Test
    public void onClick_whenGuessIsNotCorrect_triggersAnsweredIncorrectlyEvent() {
        when(quiz.answerQuestion(any(Answer.class))).thenReturn(false);
        answerActuator.onClick(trueButton);
        verify(quizListener).answeredIncorrectly();
    }

}