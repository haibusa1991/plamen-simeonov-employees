package com.employees.core;

import com.employees.model.Employee;
import com.employees.model.EmployeePair;
import com.employees.model.TableDataEmployeePair;
import com.employees.model.Project;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PairFinderTest {

    @Test
    void findAllPairProjects() {
    }

    @Test
    void populateProjects() {
    }

    @Test
    void getBestPairIds() {
    }

    @Test
    void findAllProjects() {
    }

    @Test
    void findPairOverlapsForProject_returnsCorrectOneOverlap() {
        Project project = new Project();
        project.addEmployee(new Employee("1", "10", LocalDate.of(2023, 1, 1), LocalDate.of(2023, 1, 15)));
        project.addEmployee(new Employee("2", "10", LocalDate.of(2023, 2, 1), LocalDate.of(2023, 2, 15)));
        project.addEmployee(new Employee("3", "10", LocalDate.of(2023, 1, 10), LocalDate.of(2023, 1, 20)));
        project.addEmployee(new Employee("4", "10", LocalDate.of(2023, 3, 1), LocalDate.of(2023, 3, 15)));

        EmployeePair pair = new EmployeePair("1", "3", "0", 0);

        PairFinder pairFinder = new PairFinder(new HashSet<>());
        List<TableDataEmployeePair> pairOverlapsForProject = pairFinder.findPairOverlapsForProject(project, pair);

        String expected = "1 - 3, 10, 6 days";
        String actual = pairOverlapsForProject.get(0).toString();

        assertEquals(expected, actual);
    }

    @Test
    void findPairOverlapsForProject_returnsCorrectMultipleOverlaps() {
        Project project = new Project();
        project.addEmployee(new Employee("1", "10", LocalDate.of(2023, 1, 1), LocalDate.of(2023, 1, 15)));
        project.addEmployee(new Employee("1", "10", LocalDate.of(2023, 2, 1), LocalDate.of(2023, 2, 16)));
        project.addEmployee(new Employee("1", "10", LocalDate.of(2023, 3, 1), LocalDate.of(2023, 3, 17)));
        project.addEmployee(new Employee("2", "10", LocalDate.of(2023, 2, 1), LocalDate.of(2023, 2, 15)));
        project.addEmployee(new Employee("3", "10", LocalDate.of(2023, 1, 10), LocalDate.of(2023, 1, 20)));
        project.addEmployee(new Employee("3", "10", LocalDate.of(2023, 2, 10), LocalDate.of(2023, 2, 20)));
        project.addEmployee(new Employee("3", "10", LocalDate.of(2023, 3, 10), LocalDate.of(2023, 3, 20)));
        project.addEmployee(new Employee("4", "10", LocalDate.of(2023, 3, 1), LocalDate.of(2023, 3, 15)));

        EmployeePair pair = new EmployeePair("1", "3", "0", 0);

        PairFinder pairFinder = new PairFinder(new HashSet<>());
        List<TableDataEmployeePair> pairOverlapsForProject = pairFinder.findPairOverlapsForProject(project, pair);

        String expected1 = "1 - 3, 10, 6 days";
        String expected2 = "1 - 3, 10, 7 days";
        String expected3 = "1 - 3, 10, 8 days";
        String actual1 = pairOverlapsForProject.get(0).toString();
        String actual2 = pairOverlapsForProject.get(1).toString();
        String actual3 = pairOverlapsForProject.get(2).toString();

        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
    }

    @Test
    void findPairOverlapsForProject_returnsEmptyNoOverlap() {
        Project project = new Project();
        project.addEmployee(new Employee("1", "10", LocalDate.of(2023, 1, 1), LocalDate.of(2023, 1, 15)));
        project.addEmployee(new Employee("2", "10", LocalDate.of(2023, 2, 1), LocalDate.of(2023, 2, 15)));
        project.addEmployee(new Employee("3", "10", LocalDate.of(2023, 1, 20), LocalDate.of(2023, 1, 31)));
        project.addEmployee(new Employee("4", "10", LocalDate.of(2023, 3, 1), LocalDate.of(2023, 3, 15)));

        EmployeePair pair = new EmployeePair("1", "3", "0", 0);

        PairFinder pairFinder = new PairFinder(new HashSet<>());
        List<TableDataEmployeePair> pairOverlapsForProject = pairFinder.findPairOverlapsForProject(project, pair);

        int expected = 0;
        int actual = pairOverlapsForProject.size();

        assertEquals(expected, actual);
    }

    @Test
    void findPairOverlapsForProject_returnsEmptyNonExistentEmployees() {
        Project project = new Project();
        project.addEmployee(new Employee("1", "10", LocalDate.of(2023, 1, 1), LocalDate.of(2023, 1, 15)));
        project.addEmployee(new Employee("2", "10", LocalDate.of(2023, 2, 1), LocalDate.of(2023, 2, 15)));
        project.addEmployee(new Employee("3", "10", LocalDate.of(2023, 1, 10), LocalDate.of(2023, 1, 20)));
        project.addEmployee(new Employee("4", "10", LocalDate.of(2023, 3, 1), LocalDate.of(2023, 3, 15)));

        EmployeePair pair = new EmployeePair("5", "6", "0", 0);

        PairFinder pairFinder = new PairFinder(new HashSet<>());
        List<TableDataEmployeePair> pairOverlapsForProject = pairFinder.findPairOverlapsForProject(project, pair);

        int expected = 0;
        int actual = pairOverlapsForProject.size();

        assertEquals(expected, actual);
    }

    @Test
    void findPairOverlapsForProject_returnsEmptyOneEmployeeInProject() {
        Project project = new Project();
        project.addEmployee(new Employee("1", "10", LocalDate.of(2023, 1, 1), LocalDate.of(2023, 1, 15)));

        EmployeePair pair = new EmployeePair("1", "3", "0", 0);

        PairFinder pairFinder = new PairFinder(new HashSet<>());
        List<TableDataEmployeePair> pairOverlapsForProject = pairFinder.findPairOverlapsForProject(project, pair);

        int expected = 0;
        int actual = pairOverlapsForProject.size();

        assertEquals(expected, actual);
    }

    @Test
    void findPairOverlapsForProject_returnsCorrectDuplicateOverlaps() {
        Project project = new Project();
        project.addEmployee(new Employee("1", "10", LocalDate.of(2023, 1, 1), LocalDate.of(2023, 1, 15)));
        project.addEmployee(new Employee("1", "10", LocalDate.of(2023, 1, 10), LocalDate.of(2023, 1, 20)));
        project.addEmployee(new Employee("2", "10", LocalDate.of(2023, 2, 1), LocalDate.of(2023, 2, 15)));
        project.addEmployee(new Employee("3", "10", LocalDate.of(2023, 1, 10), LocalDate.of(2023, 1, 20)));
        project.addEmployee(new Employee("4", "10", LocalDate.of(2023, 3, 1), LocalDate.of(2023, 3, 15)));

        EmployeePair pair = new EmployeePair("1", "3", "0", 0);

        PairFinder pairFinder = new PairFinder(new HashSet<>());
        List<TableDataEmployeePair> pairOverlapsForProject = pairFinder.findPairOverlapsForProject(project, pair);

        String expected1 = "1 - 3, 10, 6 days";
        String expected2 = "1 - 3, 10, 11 days";
        String actual1 = pairOverlapsForProject.get(0).toString();
        String actual2 = pairOverlapsForProject.get(1).toString();

        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
    }

    @Test
    void findAllCommonProjectsForPair_returnsCorrectOneProject() {
        Set<Employee> employees = Set.of(
                new Employee("1", "10", LocalDate.of(2023, 1, 1), LocalDate.of(2023, 1, 15)),
                new Employee("2", "10", LocalDate.of(2023, 2, 1), LocalDate.of(2023, 2, 15)),
                new Employee("3", "10", LocalDate.of(2023, 1, 10), LocalDate.of(2023, 1, 20)),
                new Employee("4", "10", LocalDate.of(2023, 3, 1), LocalDate.of(2023, 3, 15))
        );

        PairFinder pairFinder = new PairFinder(employees);
        List<TableDataEmployeePair> projects = pairFinder.findAllCommonProjectsForPair(new EmployeePair("1", "3", "0", 0)).stream().toList();

        String expected = "1 - 3, 10, 6 days";
        String actual = projects.get(0).toString();

        assertEquals(expected, actual);
    }

    @Test
    void findAllCommonProjectsForPair_returnsCorrectMultipleProjects() {
        Set<Employee> employees = Set.of(
                new Employee("1", "10", LocalDate.of(2023, 1, 1), LocalDate.of(2023, 1, 15)),
                new Employee("2", "10", LocalDate.of(2023, 2, 1), LocalDate.of(2023, 2, 15)),
                new Employee("3", "10", LocalDate.of(2023, 1, 10), LocalDate.of(2023, 1, 20)),
                new Employee("4", "10", LocalDate.of(2023, 3, 1), LocalDate.of(2023, 3, 15)),

                new Employee("1", "12", LocalDate.of(2022, 1, 1), LocalDate.of(2023, 1, 15)),
                new Employee("5", "12", LocalDate.of(2023, 2, 1), LocalDate.of(2023, 2, 15)),
                new Employee("3", "12", LocalDate.of(2022, 1, 10), LocalDate.of(2023, 1, 20)),
                new Employee("6", "12", LocalDate.of(2023, 3, 1), LocalDate.of(2023, 3, 15)),

                new Employee("7", "15", LocalDate.of(2022, 1, 1), LocalDate.of(2023, 1, 15)),
                new Employee("8", "15", LocalDate.of(2023, 2, 1), LocalDate.of(2023, 2, 15)),
                new Employee("9", "15", LocalDate.of(2022, 1, 10), LocalDate.of(2023, 1, 20)),
                new Employee("10", "15", LocalDate.of(2023, 3, 1), LocalDate.of(2023, 3, 15)),

                new Employee("1", "20", LocalDate.of(2022, 1, 1), LocalDate.of(2023, 6, 1)),
                new Employee("11", "20", LocalDate.of(2023, 2, 1), LocalDate.of(2023, 2, 15)),
                new Employee("3", "20", LocalDate.of(2022, 1, 1), LocalDate.of(2023, 6, 1)),
                new Employee("12", "20", LocalDate.of(2023, 3, 1), LocalDate.of(2023, 3, 15))
        );

        PairFinder pairFinder = new PairFinder(employees);
        List<TableDataEmployeePair> projects = pairFinder
                .findAllCommonProjectsForPair(new EmployeePair("1", "3", "0", 0)).stream().toList();

        String expected1 = "1 - 3, 20, 517 days";
        String expected2 = "1 - 3, 12, 371 days";
        String expected3 = "1 - 3, 10, 6 days";
        String actual1 = projects.get(0).toString();
        String actual2 = projects.get(1).toString();
        String actual3 = projects.get(2).toString();


        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);

    }

    @Test
    void findBestPairOfProject_returnsCorrectPairOnePeriod() {
        Project project = new Project();
        project.addEmployee(new Employee("1", "10", LocalDate.of(2023, 1, 1), LocalDate.of(2023, 1, 15)));
        project.addEmployee(new Employee("2", "10", LocalDate.of(2023, 2, 1), LocalDate.of(2023, 2, 15)));
        project.addEmployee(new Employee("3", "10", LocalDate.of(2023, 1, 10), LocalDate.of(2023, 1, 20)));
        project.addEmployee(new Employee("4", "10", LocalDate.of(2023, 3, 1), LocalDate.of(2023, 3, 15)));
        project.addEmployee(new Employee("5", "10", LocalDate.of(2022, 1, 1), LocalDate.of(2023, 1, 1)));
        project.addEmployee(new Employee("6", "10", LocalDate.of(2022, 1, 1), LocalDate.of(2023, 1, 1)));

        PairFinder pairFinder = new PairFinder(new HashSet<>());
        EmployeePair bestPairOfProject = pairFinder.findBestPairOfProject(project);

        String expectedId1 = "5";
        String expectedId2 = "6";

        assertEquals(expectedId1, bestPairOfProject.getEmployee1id());
        assertEquals(expectedId2, bestPairOfProject.getEmployee2id());
    }

    @Test
    void findBestPairOfProject_returnsCorrectPairMultiplePeriods() {
        Project project = new Project();
        project.addEmployee(new Employee("1", "10", LocalDate.of(2023, 1, 1), LocalDate.of(2023, 1, 15)));
        project.addEmployee(new Employee("2", "10", LocalDate.of(2023, 2, 1), LocalDate.of(2023, 2, 15)));
        project.addEmployee(new Employee("3", "10", LocalDate.of(2023, 1, 10), LocalDate.of(2023, 1, 20)));
        project.addEmployee(new Employee("4", "10", LocalDate.of(2023, 3, 1), LocalDate.of(2023, 3, 15)));
        project.addEmployee(new Employee("1", "10", LocalDate.of(2022, 1, 1), LocalDate.of(2023, 1, 1)));
        project.addEmployee(new Employee("3", "10", LocalDate.of(2022, 1, 1), LocalDate.of(2023, 1, 1)));

        PairFinder pairFinder = new PairFinder(new HashSet<>());
        EmployeePair bestPairOfProject = pairFinder.findBestPairOfProject(project);

        String expectedId1 = "1";
        String expectedId2 = "3";
        long expectedDaysTogether = 366;

        assertEquals(expectedId1, bestPairOfProject.getEmployee1id());
        assertEquals(expectedId2, bestPairOfProject.getEmployee2id());
        assertEquals(expectedDaysTogether, bestPairOfProject.getDaysWorkedTogether());
    }

    @Test
    void findBestPair_returnsCorrectPairOnePeriod() {
        Set<Employee> employees = Set.of(
                new Employee("1", "10", LocalDate.of(2023, 1, 1), LocalDate.of(2023, 1, 15)),
                new Employee("2", "10", LocalDate.of(2023, 2, 1), LocalDate.of(2023, 2, 15)),
                new Employee("3", "10", LocalDate.of(2023, 1, 10), LocalDate.of(2023, 1, 20)),
                new Employee("4", "10", LocalDate.of(2023, 3, 1), LocalDate.of(2023, 3, 15)),
                new Employee("10", "15", LocalDate.of(2022, 1, 1), LocalDate.of(2023, 1, 1)),
                new Employee("20", "15", LocalDate.of(2023, 2, 1), LocalDate.of(2023, 2, 15)),
                new Employee("30", "15", LocalDate.of(2022, 1, 1), LocalDate.of(2023, 1, 1)),
                new Employee("40", "15", LocalDate.of(2023, 3, 1), LocalDate.of(2023, 3, 15))
        );

        PairFinder pairFinder = new PairFinder(employees);
        EmployeePair bestPair = pairFinder.findBestPair();

        String expectedId1 = "10";
        String expectedId2 = "30";
        long expectedDaysTogether = 366;

        assertEquals(expectedId1, bestPair.getEmployee1id());
        assertEquals(expectedId2, bestPair.getEmployee2id());
        assertEquals(expectedDaysTogether, bestPair.getDaysWorkedTogether());
    }


    @Test
    void findBestPair_returnsCorrectPairMultiplePeriods() {
        Project project = new Project();
        project.addEmployee(new Employee("1", "10", LocalDate.of(2023, 1, 1), LocalDate.of(2023, 1, 15)));
        project.addEmployee(new Employee("2", "10", LocalDate.of(2023, 2, 1), LocalDate.of(2023, 2, 15)));
        project.addEmployee(new Employee("3", "10", LocalDate.of(2023, 1, 10), LocalDate.of(2023, 1, 20)));
        project.addEmployee(new Employee("4", "10", LocalDate.of(2023, 3, 1), LocalDate.of(2023, 3, 15)));
        project.addEmployee(new Employee("1", "10", LocalDate.of(2022, 1, 1), LocalDate.of(2023, 1, 1)));
        project.addEmployee(new Employee("3", "10", LocalDate.of(2022, 1, 1), LocalDate.of(2023, 1, 1)));

        project.addEmployee(new Employee("10", "15", LocalDate.of(2023, 1, 1), LocalDate.of(2023, 1, 15)));
        project.addEmployee(new Employee("20", "15", LocalDate.of(2023, 2, 1), LocalDate.of(2023, 2, 15)));
        project.addEmployee(new Employee("30", "15", LocalDate.of(2023, 1, 10), LocalDate.of(2023, 1, 20)));
        project.addEmployee(new Employee("40", "15", LocalDate.of(2023, 3, 1), LocalDate.of(2023, 3, 15)));
        project.addEmployee(new Employee("10", "15", LocalDate.of(2022, 1, 1), LocalDate.of(2023, 1, 1)));
        project.addEmployee(new Employee("30", "15", LocalDate.of(2022, 1, 1), LocalDate.of(2023, 1, 1)));
    }
}