package com.example.handlingformsubmission;

import com.example.handlingformsubmission.dto.Result;
import com.example.handlingformsubmission.dto.Test;
import org.springframework.stereotype.Component;

@Component
public class GatherVariable {
    private Result[] results = new Result[10];
    private int iForResult;
    private Test test1;
    private int numberOfTry = 1;
    private int iForlevel = 4;
    private int breaking;

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
