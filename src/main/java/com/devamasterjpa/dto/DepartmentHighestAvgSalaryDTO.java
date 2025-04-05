package com.devamasterjpa.dto;

public class DepartmentHighestAvgSalaryDTO {
    private String departmentName;
    private Double avgSalary;
    public DepartmentHighestAvgSalaryDTO(Object... args) {
        this.departmentName = (String) args[0];
        this.avgSalary = (Double) args[1];
    }

    public DepartmentHighestAvgSalaryDTO() {
    }

    public Double getAvgSalary() {
        return avgSalary;
    }

    public void setAvgSalary(Double avgSalary) {
        this.avgSalary = avgSalary;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
