package com.employees.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Project {
    private final List<Employee> projectEmployees;

    public Project() {
        this.projectEmployees = new ArrayList<>();
    }

    public boolean addEmployee(Employee employee) {
        return this.projectEmployees.add(employee);
    }

    public List<Employee> getAllEmployees(){
        return Collections.unmodifiableList(this.projectEmployees);
    }

}
