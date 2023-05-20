package com.employees.core;

import com.employees.model.Employee;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeeParser {

    public static List<Employee> getAllEmployees(File csvFile) throws IllegalArgumentException, IOException {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(csvFile));
        } catch (IOException e) {
            throw new IOException("Error reading CSV file from disk.");
        }

        List<Employee> employees = new ArrayList<>();

        int currentLineNo = 1;
        String currentLine = reader.readLine();
        while (currentLine != null) {
            try {
                employees.add(parseEmployeeData(currentLine));
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException(e.getMessage() + " Error parsing data on line " + currentLineNo + ".");
            }

            currentLine = reader.readLine();
            currentLineNo++;
        }

        return employees;
    }

    private static Employee parseEmployeeData(String rawInput) {
        String[] tokens = rawInput.split(",\\s++");

        if (tokens.length != 4) {
            throw new IllegalArgumentException("Malformed CSV data.");
        }

        String employeeId = tokens[0];
        String projectId = tokens[1];
        LocalDate startDate = DateParser.parseDate(tokens[2]);
        LocalDate endDate = tokens[3].equalsIgnoreCase("NULL") ? LocalDate.now() : DateParser.parseDate(tokens[3]);

        return new Employee(employeeId, projectId, startDate, endDate);
    }

}
