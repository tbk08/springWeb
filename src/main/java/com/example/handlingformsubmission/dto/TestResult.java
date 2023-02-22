package com.example.handlingformsubmission.dto;

public class TestResult {
    private Result[] results;
    private String studentInfo;

    public Result[] getResults() {
        return results;
    }

    public void setResults(Result[] results) {
        this.results = results;
    }

    public String getStudentInfo() {
        return studentInfo;
    }

    public void setStudentInfo(String studentInfo) {
        this.studentInfo = studentInfo;
    }

    public TestResult(Result[] results, String studentInfo) {
        this.results = results;
        this.studentInfo = studentInfo;
    }
}
