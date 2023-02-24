package com.example.handlingformsubmission.controller;

import com.example.handlingformsubmission.GatherVariable;
import com.example.handlingformsubmission.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.Arrays;

@Controller
@RequestMapping("/test")
public class TestController {
    private final GatherVariable gatherVariable;
    private Test test;

    @Autowired
    public TestController(GatherVariable gatherVariable, Test test) {
        this.test = test;
        this.gatherVariable = gatherVariable;
    }

    //todo убрать бизнес логику в сервисы
    //todo спрашивать имя у студента

    @GetMapping("")
    public String showQuestion(Model model) throws IOException {
        //toDo исправить обработку ошибки если файл не будет найден
        //todo хендлер для обработки ошибок

        int level = 10;

        if (gatherVariable.getBreaking() != level) {
            test = gatherVariable.getCurrentTestQuestion();
            model.addAttribute("showQuestion", test.getText() +
                    " " + Arrays.toString(test.getAnswer()));

            gatherVariable.setAskedQuestion(test);

            model.addAttribute("test", new Answer());

            gatherVariable.setBreaking(gatherVariable.getBreaking() + 1);

        } else {
            return "testExit";
        }
        return "/firstView";
    }

    @PostMapping("")
    public String getAnswer(@ModelAttribute Answer answer, Model model) throws IOException {
        gatherVariable.setCheckResult(answer.equals(test.getTrueAnswer()));
        gatherVariable.setiForlevel(gatherVariable.nextIForLevel
                (gatherVariable.isCheckResult(), gatherVariable.getNumberOfTry(), gatherVariable.getiForlevel()));
        gatherVariable.setNumberOfTry(gatherVariable.nextIForNumberOfTry
                (gatherVariable.isCheckResult(), gatherVariable.getNumberOfTry()));


        model.addAttribute("answer", answer);

        model.addAttribute("check", gatherVariable.isCheckResult());

        gatherVariable.setResults(gatherVariable.saveResult
                (gatherVariable.isCheckResult(), test, answer));

        gatherVariable.setiForResult(gatherVariable.getiForResult() + 1);

        gatherVariable.toFileWriter(gatherVariable);

        return "redirect:/test";
    }
}
