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

    public boolean answerQuestion(Answer answer) {
        boolean correct = currentQuestion.isTrue() == answer.equals(Answer.TRUE);

        currentQuestion = questionBank.nextQuestion();
        return correct;
    }
}
