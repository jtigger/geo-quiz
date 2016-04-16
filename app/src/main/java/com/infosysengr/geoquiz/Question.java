package com.infosysengr.geoquiz;

public class Question {
    private int questionResId;
    private boolean isTrue;

    public Question(int questionResId, boolean isTrue) {
        this.questionResId = questionResId;
        this.isTrue = isTrue;
    }

    public int getQuestionResId() {
        return questionResId;
    }

    public boolean isTrue() {
        return isTrue;
    }
}
