package com.example.handlingformsubmission.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.*;

import java.nio.file.Paths;

@Component
public class TestReader {
    public Test[][] fileReading(String path) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(Paths.get(path).toFile(), Test[][].class);
    }

}
