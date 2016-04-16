package com.infosysengr.geoquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity implements QuizListener {
    private Button trueButton;
    private Button falseButton;
    private Button maybeButton;
    private Quiz quiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        quiz = new Quiz(new InMemoryQuestionBank());

        setContentView(R.layout.activity_quiz);
        trueButton = (Button) findViewById(R.id.true_button);
        falseButton = (Button) findViewById(R.id.false_button);
        maybeButton = (Button) findViewById(R.id.maybe_button);

        AnswerActuator answerActuator = new AnswerActuator(
                trueButton,
                falseButton,
                maybeButton,
                quiz,
                this);

        displayNextQuestion();
    }

    private void displayNextQuestion() {
        TextView questionTextView = (TextView) findViewById(R.id.question_text_view);
        questionTextView.setText(quiz.getCurrentQuestion().getQuestionResId());
    }

    @Override
    public void answeredCorrectly() {
        Toast.makeText(
                QuizActivity.this,
                R.string.correct_toast,
                Toast.LENGTH_LONG)
                .show();
        displayNextQuestion();
    }

    @Override
    public void answeredIncorrectly() {
        Toast.makeText(
                QuizActivity.this,
                R.string.incorrect_toast,
                Toast.LENGTH_LONG)
                .show();
        displayNextQuestion();
    }

    @Override
    public void skippedQuestion() {
        Toast.makeText(
                QuizActivity.this,
                R.string.indecisive_toast,
                Toast.LENGTH_LONG)
                .show();
        displayNextQuestion();
    }
}

