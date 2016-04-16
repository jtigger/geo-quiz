package com.infosysengr.geoquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends Activity {
    public static final String EXTRA_ANSWER_IS_TRUE = "com.infosysengr.geoquiz.answer_is_true";
    public static final String EXTRA_ANSWER_SHOWN = "com.infosysengr.geoquiz.answer_shown";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        setAnswerShownResult(false);

        final boolean questionIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false);
        final TextView answerTextView = (TextView) findViewById(R.id.answerTextView);
        final Button answerButton = (Button) findViewById(R.id.showAnswerButton);

        answerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answerTextView.setText(questionIsTrue ? R.string.true_button : R.string.false_button);
                setAnswerShownResult(true);
            }
        });
    }

    private void setAnswerShownResult(boolean isAnswerShown) {
        Intent data = new Intent();
        data.putExtra(EXTRA_ANSWER_SHOWN, isAnswerShown);
        setResult(RESULT_OK, data);
    }
}
