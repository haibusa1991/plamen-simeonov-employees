package com.employees.model;

import java.time.LocalDate;

public class Employee {
    private String id;
    private String projectId;
    private LocalDate startDate;
    private LocalDate endDate;

    public Employee(String id, String projectId, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.projectId = projectId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getId() {
        return id;
    }

    public String getProjectId() {
        return projectId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }
}
