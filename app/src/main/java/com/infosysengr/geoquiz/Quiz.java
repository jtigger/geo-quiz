package com.infosysengr.geoquiz;

public class Quiz {
    private final QuestionBank questionBank;
    private Question currentQuestion;
    private boolean cheating;

    public Quiz(QuestionBank questionBank) {
        this.questionBank = questionBank;
        this.cheating = false;
        this.currentQuestion = questionBank.nextQuestion();
    }

    public Question getCurrentQuestion() {
        return currentQuestion;
    }

    public boolean answerQuestion(Answer answer) {
        boolean correct =
                currentQuestion.isTrue() == answer.equals(Answer.TRUE) &&
                !cheating;

        currentQuestion = questionBank.nextQuestion();
        return correct;
    }

    public void setCheating(boolean cheating) {
        this.cheating = cheating;
    }

    public boolean isCheating() {
        return cheating;
    }
}
