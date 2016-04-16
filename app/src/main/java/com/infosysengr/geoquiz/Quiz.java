package com.infosysengr.geoquiz;

public class Quiz {
    private final QuestionBank questionBank;

    public Quiz(QuestionBank questionBank) {
        this.questionBank = questionBank;
    }

    public Question currentQuestion() {
        return questionBank.nextQuestion();
    }
}
