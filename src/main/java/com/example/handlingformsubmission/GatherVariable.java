package com.example.handlingformsubmission;

import com.example.handlingformsubmission.dto.Result;
import com.example.handlingformsubmission.dto.Test;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GatherVariable {
    private List<Test> askedQuestion;
    private final Result[] results = new Result[10];
    private int iForResult;
    private Test test1;
    private int numberOfTry = 1;
    private int iForlevel = 4;
    private int breaking;
    private boolean checkResult;

    public List<Test> getAskedQuestion() {
        return askedQuestion;
    }

    public void setAskedQuestion(Test test1) {
        if (test1 != null)
            this.askedQuestion.add(test1);
    }

    public boolean isCheckResult() {
        return checkResult;
    }

    public void setCheckResult(boolean checkResult) {
        this.checkResult = checkResult;
    }

    public Result[] getResults() {
        return results;
    }

    public void setResults(Result results) {
        this.results[getiForResult()] = results;
    }

    public int getiForResult() {
        return iForResult;
    }

    public void setiForResult(int iForResult) {
        this.iForResult = iForResult;
    }

    public Test getTest1() {
        return test1;
    }

    public void setTest1(Test test1) {
        this.test1 = test1;
    }

    public int getNumberOfTry() {
        return numberOfTry;
    }

    public void setNumberOfTry(int numberOfTry) {
        this.numberOfTry = numberOfTry;
    }

    public int getiForlevel() {
        return iForlevel;
    }

    public void setiForlevel(int iForlevel) {
        this.iForlevel = iForlevel;
    }

    public int getBreaking() {
        return breaking;
    }

    public void setBreaking(int breaking) {
        this.breaking = breaking;
    }
}
