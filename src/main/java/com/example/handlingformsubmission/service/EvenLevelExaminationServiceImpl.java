package com.example.handlingformsubmission.service;

import com.example.handlingformsubmission.dto.Answer;
import com.example.handlingformsubmission.dto.Result;
import com.example.handlingformsubmission.dto.Test;
import com.example.handlingformsubmission.dto.TestResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EvenLevelExaminationServiceImpl extends MainLevelExamination implements Examination {
    private final int level; // кол-во уровней сложности

    public EvenLevelExaminationServiceImpl(int level) {
        this.level = level;
    }

    @Override
    public TestResult examination(Test[][] questions, Scanner scanner) {
        Result[] results = new Result[level];
        String infoStudent = getInfoStudent();
        TestResult testResult = new TestResult(results, infoStudent);

        List<Test> askedQuestion = new ArrayList<>();
        int breaking = 0;
        String check = "";
        int numberOfTry = 2;
        int iForLevel = level / 2 - 1;
        int iForResultsFirst = 0;
        boolean checkResult;

        while (breaking != level) {
            Test currentQuestion = getCurrentQuestion(questions, askedQuestion, iForLevel);
            askedQuestion.add(currentQuestion);
            Answer answer = convertingPrint(currentQuestion, check);
            checkResult = checkAnswer(currentQuestion, answer);
            results[iForResultsFirst] = saveResult(checkResult, currentQuestion, answer);
            iForResultsFirst++;
            iForLevel = nextIForLevel(checkResult, numberOfTry, iForLevel);
            numberOfTry = nextIForNumberOfTry(checkResult, numberOfTry);
            breaking++;
        }
        return testResult;
    }
}
