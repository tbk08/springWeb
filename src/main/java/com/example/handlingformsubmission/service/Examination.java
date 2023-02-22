package com.example.handlingformsubmission.service;

import com.example.handlingformsubmission.dto.Test;
import com.example.handlingformsubmission.dto.TestResult;

import java.util.Scanner;

public interface Examination {
    TestResult examination(Test[][] questions, Scanner scanner);
}
