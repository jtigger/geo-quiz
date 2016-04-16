package com.infosysengr.geoquiz;

public interface QuizListener {
    public void answeredCorrectly();
    public void answeredIncorrectly();
    public void skippedQuestion();
}
