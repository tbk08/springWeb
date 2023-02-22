package com.example.handlingformsubmission.dto;

public class Result {
    private String question;
    private int level;
    private Answer answer;
    private boolean checkResult;


    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public boolean getCheckResult() {
        return checkResult;
    }

    public void setCheckResult(boolean checkResult) {
        this.checkResult = checkResult;
    }

    public Result(String question, int level, Answer answer, boolean checkResult) {
        this.question = question;
        this.level = level;
        this.answer = answer;
        this.checkResult = checkResult;
    }

    public Result() {
    }
}
