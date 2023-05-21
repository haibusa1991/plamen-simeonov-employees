package com.employees.core;

import com.employees.model.Employee;
import com.employees.model.EmployeePair;
import com.employees.model.TableDataEmployeePair;

import java.io.File;
import java.io.IOException;
import java.util.Set;

public class Parser {

    private final File csvFile;

    public Parser(File csvFile) {
        this.csvFile = csvFile;
    }

    public Set<TableDataEmployeePair> getEmployeePairs() throws IllegalArgumentException, IOException {
        Set<Employee> allEmployees = EmployeeParser.getAllEmployees(this.csvFile);

        PairFinder pairFinder = new PairFinder(allEmployees);
        EmployeePair bestPair = pairFinder.findBestPair();
        return pairFinder.findAllCommonProjectsForPair(bestPair);
    }

}
