package com.example.handlingformsubmission.service;

import com.example.handlingformsubmission.dto.Answer;
import com.example.handlingformsubmission.dto.Result;
import com.example.handlingformsubmission.dto.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public abstract class MainLevelExamination {
    public int nextIForLevel(boolean checkResult, int numberOfTry, int iForLevel) {
        if (checkResult && numberOfTry == 2) return iForLevel + 1;
        else if (!checkResult && numberOfTry == 1) {
            return iForLevel - 1;
        }
        return iForLevel;
    }

    public int nextIForNumberOfTry(boolean checkResult, int numberOfTry) {
        if (numberOfTry == 2) return numberOfTry - 1;
        return numberOfTry + 1;
    }


    public boolean checkAnswer(Test currentQuestion, Answer answer) {
        return currentQuestion.getTrueAnswer().equals(answer);
    }

    public Result saveResult(boolean checkResult, Test currentQuestion, Answer answer) {
        if (checkResult)
            return new Result(currentQuestion.getText(), currentQuestion.getLevel(), answer, true);
        else
            return new Result(currentQuestion.getText(), currentQuestion.getLevel(), answer, false);
    }

    public Test getCurrentQuestion(Test[][] questions, List<Test> askedQuestions, int iForLevel) {

        List<Test> notAskedQuestions = new ArrayList<>();

        for (int j = 0; j < questions[iForLevel].length; j++) {
            if (!askedQuestions.contains(questions[iForLevel][j])) {
                notAskedQuestions.add(questions[iForLevel][j]);
            }
        }
        int ran = (int) (Math.random() * notAskedQuestions.size());
        return notAskedQuestions.get(ran);
    }

    public Answer convertingPrint(Test currentQuestion, String check) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(currentQuestion.getText());
        System.out.println("Enter one of answers as given \n"
                + Arrays.toString(currentQuestion.getAnswer()));
        check = scanner.nextLine();
        return new Answer(check);
    }

    public static String getInfoStudent() {
        Scanner in = new Scanner(System.in);
        System.out.println("Entre your full name:");
        return in.nextLine();
    }
}
