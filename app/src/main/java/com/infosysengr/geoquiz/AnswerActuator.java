package com.infosysengr.geoquiz;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;

public class AnswerActuator implements View.OnClickListener {
    private final Button trueButton;
    private final Button falseButton;
    private final Button maybeButton;
    private final Quiz quiz;
    private final QuizListener quizListener;

    public AnswerActuator(Button trueButton, Button falseButton, Button maybeButton, Quiz quiz, QuizListener quizListener) {
        this.trueButton = trueButton;
        this.falseButton = falseButton;
        this.maybeButton = maybeButton;
        this.quiz = quiz;
        this.quizListener = quizListener;
        trueButton.setOnClickListener(this);
        falseButton.setOnClickListener(this);
        maybeButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View clickedView) {
        if(clickedView.equals(maybeButton)) {
            quiz.answerQuestion(Answer.MAYBE);
            quizListener.skippedQuestion();
            return;
        }
        if(quiz.answerQuestion(answerForButton(clickedView))) {
            quizListener.answeredCorrectly();
        } else {
            quizListener.answeredIncorrectly();
        }
    }

    @NonNull
    private Answer answerForButton(View clickedView) {
        return clickedView.equals(trueButton) ? Answer.TRUE : Answer.FALSE;
    }
}
