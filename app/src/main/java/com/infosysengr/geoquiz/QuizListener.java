package com.infosysengr.geoquiz;

public interface QuizListener {
    void answeredCorrectly();
    void answeredIncorrectly();
    void skippedQuestion();
}
