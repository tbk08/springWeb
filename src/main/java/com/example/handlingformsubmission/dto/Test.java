package com.example.handlingformsubmission.dto;

import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class Test {

    private String text;
    private int level;
    private Answer[] answer;
    private Answer trueAnswer;


    public String getText() {
        return text;
    }


    public int getLevel() {
        return level;
    }


    public Answer[] getAnswer() {
        return answer;
    }


    public Answer getTrueAnswer() {
        return trueAnswer;
    }

    public Test(String text, int level, Answer[] answer, Answer trueAnswer) {
        this.text = text;
        this.level = level;
        this.answer = answer;
        this.trueAnswer = trueAnswer;
    }

    public Test() {
    }

    @Override
    public String toString() {
        return "Test{" +
                "text='" + text + '\'' +
                ", level=" + level +
                ", answer=" + Arrays.toString(answer) +
                ", trueAnswer=" + trueAnswer +
                '}';
    }
}
