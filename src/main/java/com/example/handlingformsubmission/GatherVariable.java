package com.example.handlingformsubmission;

import com.example.handlingformsubmission.dto.FileWriter;
import com.example.handlingformsubmission.dto.Result;
import com.example.handlingformsubmission.dto.Test;
import com.example.handlingformsubmission.dto.TestReader;
import com.example.handlingformsubmission.service.MainLevelExamination;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class GatherVariable extends MainLevelExamination {

    public Test[][] getTests() throws IOException {
        TestReader testReader = new TestReader();
        return testReader.fileReading("C:\\Users\\User\\IdeaProjects\\handling-form-submission\\" +
                "handling-form-submission\\src\\main\\resources\\static\\inputTen1.json");
    }

    public void toFileWriter(GatherVariable gatherVariable) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonTestResult = objectMapper.writeValueAsString(gatherVariable.getResults());
        FileWriter fileWriter = new FileWriter();
        String path = "C:\\Users\\User\\IdeaProjects\\handling-form-submission\\handling-form-submission\\src\\main\\resources\\static\\results.json";
        fileWriter.writingFile(path, jsonTestResult);
    }

    private final List<Test> askedQuestion = new ArrayList<>();

    public Test getCurrentTestQuestion() throws IOException {
        List<Test> notAskedQuestions = new ArrayList<>();

        for (int j = 0; j < getTests()[getiForlevel()].length; j++) {
            if (!getAskedQuestion().contains(getTests()[getiForlevel()][j])) {
                notAskedQuestions.add(getTests()[getiForlevel()][j]);
            }
        }

        int ran = (int) (Math.random() * notAskedQuestions.size());
        return notAskedQuestions.get(ran);
    }

    private final Result[] results = new Result[10];
    private int iForResult;
    private int numberOfTry = 2;
    private int iForlevel = 4;
    private int breaking;
    private boolean checkResult;

    public List<Test> getAskedQuestion() {
        return askedQuestion;
    }

    public void setAskedQuestion(Test test1) {
        if (test1 != null) this.askedQuestion.add(test1);
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
