package com.devamasterjpa.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "emp_table")
@JsonIgnoreProperties({"empEmail","empRank", "hibernateLazyInitializer", "handler"})
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long empId;
    private String empName;
    private String empEmail;
    @JsonIgnore
    private String empDesignation;
    @JsonProperty("emp_salary")
    private Double empSalary;
    private Integer empRank;

    @ManyToOne
    @JoinColumn(name = "deptId")
    private Department department;

    public Employee(Long empId, String empName, String empEmail, String empDesignation, Double empSalary, Integer empRank,Department department) {
        this.empId = empId;
        this.empName = empName;
        this.empEmail = empEmail;
        this.empDesignation = empDesignation;
        this.empSalary = empSalary;
        this.empRank = empRank;
        this.department = department;
    }

    public Employee() {
    }

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
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

    public Integer getEmpRank() {
        return empRank;
    }

    public void setEmpRank(Integer empRank) {
        this.empRank = empRank;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", empEmail='" + empEmail + '\'' +
                ", empDesignation='" + empDesignation + '\'' +
                ", empSalary=" + empSalary +
                ", empRank=" + empRank +
                '}';
    }
}
