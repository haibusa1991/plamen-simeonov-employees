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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (!id.equals(employee.id)) return false;
        if (!projectId.equals(employee.projectId)) return false;
        if (!startDate.equals(employee.startDate)) return false;
        return endDate.equals(employee.endDate);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + projectId.hashCode();
        result = 31 * result + startDate.hashCode();
        result = 31 * result + endDate.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Employee{" +
               "id='" + id + '\'' +
               ", projectId='" + projectId + '\'' +
               ", startDate=" + startDate +
               ", endDate=" + endDate +
               '}';
    }
}
