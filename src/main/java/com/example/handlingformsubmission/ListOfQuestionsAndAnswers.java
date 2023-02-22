package com.example.handlingformsubmission;

import com.example.handlingformsubmission.service.MainLevelExamination;
import com.example.handlingformsubmission.dto.Test;
import org.springframework.stereotype.Component;

@Component
public class ListOfQuestionsAndAnswers extends MainLevelExamination {
    private Test[][] tests;

    public Test[][] getTests() {
        return tests;
    }

    public void setTests(Test[][] tests) {
        this.tests = tests;
    }


}
