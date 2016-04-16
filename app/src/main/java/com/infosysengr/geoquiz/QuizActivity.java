package com.infosysengr.geoquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {
    private Button trueButton;
    private Button falseButton;
    private Button maybeButton;
    private Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_quiz);
        trueButton = (Button) findViewById(R.id.true_button);

        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(
                        QuizActivity.this,
                        R.string.incorrect_toast,
                        Toast.LENGTH_SHORT)
                        .show();
            }
        });

        falseButton = (Button) findViewById(R.id.false_button);
        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(
                        QuizActivity.this,
                        R.string.correct_toast,
                        Toast.LENGTH_LONG)
                        .show();
            }
        });

        maybeButton = (Button) findViewById(R.id.maybe_button);
        maybeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(
                        QuizActivity.this,
                        R.string.indecisive_toast,
                        Toast.LENGTH_LONG)
                        .show();
            }
        });

        nextButton = (Button) findViewById(R.id.next_button);
        TextView questionTextView = (TextView) findViewById(R.id.question_text_view);
    }
}

