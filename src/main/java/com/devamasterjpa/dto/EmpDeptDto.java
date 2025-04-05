package com.devamasterjpa.dto;

public class EmpDeptDto {
    private String empName;
    private String deptName;
    private String empDesignation;
    private Double empSalary;

    public EmpDeptDto(String empName, String deptName, String empDesignation, Double empSalary) {
        this.empName = empName;
        this.deptName = deptName;
        this.empDesignation = empDesignation;
        this.empSalary = empSalary;
    }

    public EmpDeptDto() {
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getEmpDesignation() {
        return empDesignation;
    }

    public void setEmpDesignation(String empDesignation) {
        this.empDesignation = empDesignation;
    }

    public Double getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(Double empSalary) {
        this.empSalary = empSalary;
    }
}
