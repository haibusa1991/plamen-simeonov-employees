package com.employees.model;

import javafx.beans.property.SimpleStringProperty;

public class TableDataEmployeePair {
    private final SimpleStringProperty employeeId1;
    private final SimpleStringProperty employeeId2;
    private final SimpleStringProperty projectId;
    private final SimpleStringProperty daysWorked;


    public TableDataEmployeePair(String employeeId1, String employeeId2, String projectId, String daysWorked) {
        this.employeeId1 = new SimpleStringProperty(employeeId1);
        this.employeeId2 = new SimpleStringProperty(employeeId2);
        this.projectId = new SimpleStringProperty(projectId);
        this.daysWorked = new SimpleStringProperty(daysWorked);
    }

    public String getEmployeeId1() {
        return employeeId1.get();
    }

    public SimpleStringProperty employeeId1Property() {
        return employeeId1;
    }

    public String getEmployeeId2() {
        return employeeId2.get();
    }

    public SimpleStringProperty employeeId2Property() {
        return employeeId2;
    }

    public String getProjectId() {
        return projectId.get();
    }

    public SimpleStringProperty projectIdProperty() {
        return projectId;
    }

    public String getDaysWorked() {
        return daysWorked.get();
    }

    public SimpleStringProperty daysWorkedProperty() {
        return daysWorked;
    }

    @Override
    public String toString() {
        return String.format("%s - %s, %s, %s days", this.employeeId1.get(), this.employeeId2.get(), this.projectId.get(), this.daysWorked.get());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TableDataEmployeePair that = (TableDataEmployeePair) o;

        if (!employeeId1.getValue().equals(that.employeeId1.getValue())) return false;
        if (!employeeId2.getValue().equals(that.employeeId2.getValue())) return false;
        if (!projectId.getValue().equals(that.projectId.getValue())) return false;
        return daysWorked.getValue().equals(that.daysWorked.getValue());
    }

    @Override
    public int hashCode() {
        int result = employeeId1.getValue().hashCode();
        result = 31 * result + employeeId2.getValue().hashCode();
        result = 31 * result + projectId.getValue().hashCode();
        result = 31 * result + daysWorked.getValue().hashCode();
        return result;
    }
}
