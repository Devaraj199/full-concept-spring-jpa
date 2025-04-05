package com.devamasterjpa.dto;

public class DeptAvgSalaryDto {
    private String deptName;
    private Double avgSalary;

    public DeptAvgSalaryDto(String deptName, Double avgSalary) {
        this.deptName = deptName;
        this.avgSalary = avgSalary;
    }

    public DeptAvgSalaryDto() {
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Double getAvgSalary() {
        return avgSalary;
    }

    public void setAvgSalary(Double avgSalary) {
        this.avgSalary = avgSalary;
    }
}
