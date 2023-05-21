package com.employees.core;

import com.employees.model.Employee;
import com.employees.model.EmployeePair;
import com.employees.model.TableDataEmployeePair;
import com.employees.model.Project;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class PairFinder {
    private final Map<String, Project> projects;
    private final Set<Employee> allEmployees;

    public PairFinder(Set<Employee> allEmployees) {
        this.allEmployees = allEmployees;
        this.projects = new HashMap<>();
        populateProjects();
    }

    public void populateProjects() {
        this.projects.clear();

        for (Employee employee : allEmployees) {
            String projectId = employee.getProjectId();
            this.projects.putIfAbsent(projectId, new Project());
            this.projects.get(projectId).addEmployee(employee);
        }
    }

    //working together for the longest period of time
    public EmployeePair findBestPair() {
        return this.projects.values().stream()
                .map(this::findBestPairOfProject)
                .max(Comparator.comparing(EmployeePair::getDaysWorkedTogether))
                .orElse(null);
    }

    public EmployeePair findBestPairOfProject(Project project) {
        List<Employee> employeeList = project.getAllEmployees();

        List<EmployeePair> pairs = new ArrayList<>();

        for (int i = 0; i < employeeList.size(); i++) {
            for (int j = i + 1; j < employeeList.size(); j++) {
                Employee employee1 = employeeList.get(i);
                Employee employee2 = employeeList.get(j);

                if (employee1.getId().equals(employee2.getId())) {
                    continue;
                }

                long overlap = DateParser.getTimeOverlap(employee1.getStartDate(), employee1.getEndDate(), employee2.getStartDate(), employee2.getEndDate());
                if (overlap > 0) {
                    String id1 = employee2.getId();
                    String id2 = employee1.getId();

                    if (employee1.getId().compareTo(employee2.getId()) < 0) {
                        id1 = employee1.getId();
                        id2 = employee2.getId();
                    }

                    pairs.add(new EmployeePair(id1, id2, employee1.getProjectId(), overlap));
                }
            }
        }
        return pairs.stream().max(Comparator.comparing(EmployeePair::getDaysWorkedTogether)).orElse(new EmployeePair("", "", "", -1));
    }


    public Set<TableDataEmployeePair> findAllCommonProjectsForPair(EmployeePair employeePair) {
        return this.projects.values()
                .stream()
                .map(project -> this.findPairOverlapsForProject(project, employeePair))
                .flatMap(List::stream)
                .sorted((p1,p2)->{
                    int result = Integer.compare(Integer.parseInt(p2.getDaysWorked()), Integer.parseInt(p1.getDaysWorked()));

                    if(result==0){
                        result = p2.getProjectId().compareToIgnoreCase(p1.getProjectId());
                    }

                    return result;
                })
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    public List<TableDataEmployeePair> findPairOverlapsForProject(Project project, EmployeePair employeePair) {
        List<TableDataEmployeePair> pairs = new ArrayList<>();

        List<Employee> targetEmployees = project.getAllEmployees()
                .stream()
                .filter(employee -> employee.getId().equals(employeePair.getEmployee1id()) || employee.getId().equals(employeePair.getEmployee2id()))
                .toList();

        for (int i = 0; i < targetEmployees.size() - 1; i++) {
            for (int j = i + 1; j < targetEmployees.size(); j++) {
                LocalDate firstStart = targetEmployees.get(i).getStartDate();
                LocalDate firstEnd = targetEmployees.get(i).getEndDate();
                LocalDate secondStart = targetEmployees.get(j).getStartDate();
                LocalDate secondEnd = targetEmployees.get(j).getEndDate();

                if (targetEmployees.get(i).getId().equals(targetEmployees.get(j).getId())) {
                    continue;
                }

                long timeOverlap = DateParser.getTimeOverlap(firstStart, firstEnd, secondStart, secondEnd);

                if (timeOverlap > 0) {
                    pairs.add(createTableDataEmployeePair(targetEmployees.get(i), targetEmployees.get(j), timeOverlap));
                }
            }
        }
        return pairs;
    }

    private TableDataEmployeePair createTableDataEmployeePair(Employee employee1, Employee employee2, long timeOverlap) {
        String id1 = employee2.getId();
        String id2 = employee1.getId();

        if (employee1.getId().compareTo(employee2.getId()) < 0) {
            id1 = employee1.getId();
            id2 = employee2.getId();
        }

        return new TableDataEmployeePair(
                id1,
                id2,
                employee1.getProjectId(),
                String.valueOf(timeOverlap));
    }
}
