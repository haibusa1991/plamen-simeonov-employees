package com.employees.core;

import com.employees.model.Employee;
import com.employees.model.EmployeePair;
import com.employees.model.Project;

import java.time.temporal.ChronoUnit;
import java.util.*;

public class PairFinder {
    private final Map<String, Project> projects;
    private final Set<Employee> allEmployees;

    public PairFinder(Set<Employee> allEmployees) {
        this.allEmployees = allEmployees;
        this.projects = new HashMap<>();
    }

    public List<EmployeePair> findAllPairProjects() {
        populateProjects();
        String[] bestPair = findBestPair();//working together for the longest period of time
        findAllProjects(bestPair);

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

        List<String> projectsToBeRemoved = this.projects
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue().getAllEmployees().size() == 1)
                .map(Map.Entry::getKey)
                .toList();

        for (String id : projectsToBeRemoved) {
            this.projects.remove(id);
        }
    }

    private String[] findBestPair() {
        String[] bestPair = new String[2];
        long bestOverlap = 0;

        for (Project project : projects.values()) {
            List<Employee> employeeList = project.getAllEmployees();

            for (int i = 0; i < employeeList.size(); i++) {
                Employee emp1 = employeeList.get(i);
                for (int j = i + 1; j < employeeList.size(); j++) {
                    Employee emp2 = employeeList.get(j);

                    long overlap = getTimeOverlap(emp1, emp2);
                    if (overlap > bestOverlap) {
                        bestPair[0] = emp1.getId();
                        bestPair[1] = emp2.getId();
                        bestOverlap = overlap;
                    }
                }
            }
        }
        return bestPair;
    }


    public long getTimeOverlap(Employee employee1, Employee employee2) {
        if (employee1.getStartDate().isAfter(employee2.getStartDate())) {
            Employee temp = employee2;
            employee2 = employee1;
            employee1 = temp;
        }

        if (employee1.getEndDate().isBefore(employee2.getStartDate())) {
            return -1;
        }

        if (employee1.getEndDate().isBefore(employee2.getEndDate())) {
            return Math.abs(ChronoUnit.DAYS.between(employee2.getStartDate(), employee1.getEndDate().plusDays(1)));
        }

        return Math.abs(ChronoUnit.DAYS.between(employee2.getStartDate(), employee2.getEndDate().plusDays(1)));
    }

    private void findAllProjects(String[] pairIds) {
        List<EmployeePair> pairs = new ArrayList<>();

//        for (Project project : projects.values()) {
//        project.getAllEmployees()
//                .stream()
//                .filter(employee -> employee.getId().equals(pairIds[0]) || employee.getId().equals(pairIds[1]))
//                .
//        }
    }


}
