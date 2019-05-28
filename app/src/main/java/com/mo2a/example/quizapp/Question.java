package com.mo2a.example.quizapp;

public class Question {
    private int answerId;
    private int infoId;
    private boolean answerTrue;

    public Question(int answerId, int infoId, boolean answerTrue) {
        this.answerId = answerId;
        this.answerTrue = answerTrue;
        this.infoId= infoId;
    }

    public int getInfoId() {
        return infoId;
    }

    public void setInfoId(int infoId) {
        this.infoId = infoId;
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public boolean isAnswerTrue() {
        return answerTrue;
    }

    public void setAnswerTrue(boolean answerTrue) {
        this.answerTrue = answerTrue;
    }
}
