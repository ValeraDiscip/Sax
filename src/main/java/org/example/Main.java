package org.example;

import java.io.File;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        File file = new File("task1.xml");
        File jsonFile = new File("task1.json");
        List<Employee> staff = SaxMyParser.parser(file);
        System.out.println(staff);
        LoadToJSON.loadToJSON(jsonFile, staff);

        System.out.println("Это я добавил только что))))");
    }
}