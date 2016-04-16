package com.infosysengr.geoquiz;

public class Quiz {
    private final QuestionBank questionBank;
    private Question currentQuestion;

    public Quiz(QuestionBank questionBank) {
        this.questionBank = questionBank;
        currentQuestion = questionBank.nextQuestion();
    }

    public Question getCurrentQuestion() {
        return currentQuestion;
    }

    public Question answerQuestion(Answer answer) {
        currentQuestion = questionBank.nextQuestion();
        return getCurrentQuestion();
    }
}
