package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class LoadToJSON {
    public static void loadToJSON(File file, List<Employee> staff) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            objectMapper.writeValue(file, staff);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
