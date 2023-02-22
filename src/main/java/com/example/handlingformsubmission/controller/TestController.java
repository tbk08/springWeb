package com.example.handlingformsubmission.controller;

import com.example.handlingformsubmission.GatherVariable;
import com.example.handlingformsubmission.ListOfQuestionsAndAnswers;
import com.example.handlingformsubmission.dto.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/test")
public class TestController {
    private final ListOfQuestionsAndAnswers listOfQuestionsAndAnswers;
    private GatherVariable gatherVariable;

    @Autowired
    public TestController(ListOfQuestionsAndAnswers listOfQuestionsAndAnswers, GatherVariable gatherVariable) {
        this.listOfQuestionsAndAnswers = listOfQuestionsAndAnswers;
        this.gatherVariable = gatherVariable;
    }

    //todo убрать бизнес логику в сервисы
    //todo спрашивать имя у студента

    @GetMapping("")
    public String showQuestion(Model model) throws IOException {
        TestReader testReader = new TestReader();
        listOfQuestionsAndAnswers.setTests(testReader.fileReading("C:\\Users\\User\\IdeaProjects\\handling-form-submission\\" +
                "handling-form-submission\\src\\main\\resources\\static\\inputTen1.json"));

        //toDo исправить обработку ошибки если файл не будет найден
        //todo хендлер для обработки ошибок

        int level = 10;

        if (gatherVariable.getBreaking() != level) {
            gatherVariable.setTest1(listOfQuestionsAndAnswers.getCurrentQuestion(listOfQuestionsAndAnswers.getTests(), gatherVariable.getAskedQuestion(), gatherVariable.getiForlevel()));
            model.addAttribute("showQuestion", gatherVariable.getTest1().getText() +
                    " " + Arrays.toString(gatherVariable.getTest1().getAnswer()));
            gatherVariable.setAskedQuestion((gatherVariable.getTest1()));

            model.addAttribute("test", new Answer());

            gatherVariable.setBreaking(gatherVariable.getBreaking() + 1);

        } else {
            return "testExit";
        }
        return "/firstView";
    }

    @PostMapping("")
    public String getAnswer(@ModelAttribute Answer answer, Model model) throws IOException {
        gatherVariable.setCheckResult(answer.equals(gatherVariable.getTest1().getTrueAnswer()));
        gatherVariable.setNumberOfTry(listOfQuestionsAndAnswers.nextIForNumberOfTry
                (gatherVariable.isCheckResult(), gatherVariable.getNumberOfTry()));
        gatherVariable.setiForlevel(listOfQuestionsAndAnswers.nextIForLevel
                (gatherVariable.isCheckResult(), gatherVariable.getNumberOfTry(), gatherVariable.getiForlevel()));

        model.addAttribute("answer", answer);

        model.addAttribute("check", gatherVariable.isCheckResult());

        gatherVariable.setResults(listOfQuestionsAndAnswers.saveResult
                (gatherVariable.isCheckResult(), gatherVariable.getTest1(), answer));

        gatherVariable.setiForResult(gatherVariable.getiForResult() + 1);

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonTestResult = objectMapper.writeValueAsString(gatherVariable.getResults());
        FileWriter fileWriter = new FileWriter();
        String path = "C:\\Users\\User\\IdeaProjects\\handling-form-submission\\handling-form-submission\\src\\main\\resources\\static\\results.json";
        fileWriter.writingFile(path, jsonTestResult);

        return "redirect:/test";
    }
}
