package com.employees.model;

public class EmployeePair {
    private final String employee1id;
    private final String employee2id;
    private final String projectId;
    private final long daysWorkedTogether;

    public EmployeePair(String employee1id, String employee2id, String projectId, long daysWorkedTogether) {
        this.employee1id = employee1id;
        this.employee2id = employee2id;
        this.projectId = projectId;
        this.daysWorkedTogether = daysWorkedTogether;
    }

    public String getEmployee1id() {
        return employee1id;
    }

    public String getEmployee2id() {
        return employee2id;
    }

    public String getProjectId() {
        return projectId;
    }

    public long getDaysWorkedTogether() {
        return daysWorkedTogether;
    }
}
