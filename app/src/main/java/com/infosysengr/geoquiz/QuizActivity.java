package com.infosysengr.geoquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity implements QuizListener {
    private Quiz quiz;

    private static final String TAG = "QuizActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        quiz = new Quiz(new InMemoryQuestionBank());

        setContentView(R.layout.activity_quiz);

        AnswerActuator answerActuator = new AnswerActuator(
                (Button) findViewById(R.id.true_button),
                (Button) findViewById(R.id.false_button),
                (Button) findViewById(R.id.maybe_button),
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

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() called");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause() called");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() called");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop() called");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() called");
    }
}

