package com.employees.model;

import javafx.beans.property.SimpleStringProperty;

public class EmployeePair {
    private final SimpleStringProperty employeeId1;
    private final SimpleStringProperty employeeId2;
    private final SimpleStringProperty projectId;
    private final SimpleStringProperty daysWorked;


    public EmployeePair(String employeeId1, String employeeId2, String projectId, String daysWorked) {
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
}
