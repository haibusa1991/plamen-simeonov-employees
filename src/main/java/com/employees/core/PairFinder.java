package com.employees.core;

import com.employees.model.Employee;
import com.employees.model.EmployeePair;
import com.employees.model.Project;

import java.util.*;

public class PairFinder {
    private final Map<String, Project> projects;
    private final List<Employee> allEmployees;

    public PairFinder(List<Employee> allEmployees) {
        this.allEmployees = allEmployees;
        this.projects = new HashMap<>();
    }

    public List<EmployeePair> findAllPairProjects() {
        populateProjects();
        findBestPair(); //working together for the longest period of time
        findAllProjects();

        return new ArrayList<>(List.of(
                new EmployeePair("OK 1", "OK 1", "OK 1", "OK 1"),
                new EmployeePair("OK 2", "OK 2", "OK 2", "OK 2")
        ));
    }

    private void populateProjects() {
        for (Employee employee : allEmployees) {
            String projectId = employee.getProjectId();
            this.projects.putIfAbsent(projectId, new Project());

            this.projects.get(projectId).addEmployee(employee);
        }

        //todo: sanitize - remove all projects with one employee
    }

    private void findBestPair(){
        //todo: iterate over all projects and find the best pair
    }

    private void findAllProjects(){
        //todo: iterate over all projects and find where pair has worked
    }


}
