package com.example.handlingformsubmission.dto;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class FileWriter {
    public void writingFile(String path, String jsonTestResult) throws IOException {
        File file = new File(path);
        PrintWriter printWriter = new PrintWriter(file);
        printWriter.println(jsonTestResult);
        printWriter.close();
    }
}
