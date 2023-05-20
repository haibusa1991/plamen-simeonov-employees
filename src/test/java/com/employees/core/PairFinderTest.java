package com.employees.core;

import com.employees.model.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class PairFinderTest {
    private PairFinder pairFinder;

    @BeforeEach
    void setUp() {
        this.pairFinder = new PairFinder(new HashSet<>());
    }

    @Test
    void getTimeOverlap_NoOverlap() {
        Employee employee1 = new Employee("id", "projectId", LocalDate.of(2023, 1, 1), LocalDate.of(2023, 2, 1));
        Employee employee2 = new Employee("id", "projectId", LocalDate.of(2023, 3, 1), LocalDate.of(2023, 4, 1));

        long actualEmployee1StartedFirst = pairFinder.getTimeOverlap(employee1, employee2);
        long actualEmployee2StartedFirst = pairFinder.getTimeOverlap(employee2, employee1);
        long expected = -1;

        assertEquals(expected,actualEmployee1StartedFirst);
        assertEquals(expected,actualEmployee2StartedFirst);
    }

    @Test
    void getTimeOverlap_PartialOverlap() {
        Employee employee1 = new Employee("id", "projectId", LocalDate.of(2023, 1, 1), LocalDate.of(2023, 1, 5));
        Employee employee2 = new Employee("id", "projectId", LocalDate.of(2023, 1, 3), LocalDate.of(2023, 1, 10));

        long actualEmployee1StartedFirst = pairFinder.getTimeOverlap(employee1, employee2);
        long actualEmployee2StartedFirst = pairFinder.getTimeOverlap(employee2, employee1);
        long expected = 3;

        assertEquals(expected,actualEmployee1StartedFirst);
        assertEquals(expected,actualEmployee2StartedFirst);
    }

    @Test
    void getTimeOverlap_FullOverlap() {
        Employee employee1 = new Employee("id", "projectId", LocalDate.of(2023, 1, 1), LocalDate.of(2023, 2, 1));
        Employee employee2 = new Employee("id", "projectId", LocalDate.of(2023, 1, 10), LocalDate.of(2023, 1, 15));

        long actualEmployee1StartedFirst = pairFinder.getTimeOverlap(employee1, employee2);
        long actualEmployee2StartedFirst = pairFinder.getTimeOverlap(employee2, employee1);
        long expected = 6;

        assertEquals(expected,actualEmployee1StartedFirst);
        assertEquals(expected,actualEmployee2StartedFirst);
    }

    @Test
    void getTimeOverlap_FullOverlapSamePeriod() {
        Employee employee1 = new Employee("id", "projectId", LocalDate.of(2023, 1, 1), LocalDate.of(2023, 2, 1));
        Employee employee2 = new Employee("id", "projectId", LocalDate.of(2023, 1, 1), LocalDate.of(2023, 2, 1));

        long actualEmployee1StartedFirst = pairFinder.getTimeOverlap(employee1, employee2);
        long actualEmployee2StartedFirst = pairFinder.getTimeOverlap(employee2, employee1);
        long expected = 32;

        assertEquals(expected,actualEmployee1StartedFirst);
        assertEquals(expected,actualEmployee2StartedFirst);
    }

    @Test
    void getTimeOverlap_OneDayOverlap() {
        Employee employee1 = new Employee("id", "projectId", LocalDate.of(2023, 1, 1), LocalDate.of(2023, 1, 10));
        Employee employee2 = new Employee("id", "projectId", LocalDate.of(2023, 1, 10), LocalDate.of(2023, 2, 10));

        long actualEmployee1StartedFirst = pairFinder.getTimeOverlap(employee1, employee2);
        long actualEmployee2StartedFirst = pairFinder.getTimeOverlap(employee2, employee1);
        long expected = 1;

        assertEquals(expected,actualEmployee1StartedFirst);
        assertEquals(expected,actualEmployee2StartedFirst);
    }

    @Test
    void getTimeOverlap_OneDayNoOverlap() {
        Employee employee1 = new Employee("id", "projectId", LocalDate.of(2023, 1, 1), LocalDate.of(2023, 1, 10));
        Employee employee2 = new Employee("id", "projectId", LocalDate.of(2023, 1, 11), LocalDate.of(2023, 2, 11));

        long actualEmployee1StartedFirst = pairFinder.getTimeOverlap(employee1, employee2);
        long actualEmployee2StartedFirst = pairFinder.getTimeOverlap(employee2, employee1);
        long expected = -1;

        assertEquals(expected,actualEmployee1StartedFirst);
        assertEquals(expected,actualEmployee2StartedFirst);
    }


}