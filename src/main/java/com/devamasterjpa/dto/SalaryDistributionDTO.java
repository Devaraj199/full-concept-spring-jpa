package com.devamasterjpa.dto;

import java.math.BigDecimal;

public class SalaryDistributionDTO {
    private String designation;
    private BigDecimal minSalary;
    private BigDecimal maxSalary;
    private BigDecimal avgSalary;
    private Long employeeCount;

    public SalaryDistributionDTO(String designation, BigDecimal minSalary, BigDecimal maxSalary, BigDecimal avgSalary, Long employeeCount) {
        this.designation = designation;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
        this.avgSalary = avgSalary;
        this.employeeCount = employeeCount;
    }

    public SalaryDistributionDTO() {
    }

    public BigDecimal getAvgSalary() {
        return avgSalary;
    }

    public String getDesignation() {
        return designation;
    }

    public BigDecimal getMinSalary() {
        return minSalary;
    }

    public BigDecimal getMaxSalary() {
        return maxSalary;
    }



    public Long getEmployeeCount() {
        return employeeCount;
    }

    public void setAvgSalary(BigDecimal avgSalary) {
        this.avgSalary = avgSalary;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setMinSalary(BigDecimal minSalary) {
        this.minSalary = minSalary;
    }

    public void setMaxSalary(BigDecimal maxSalary) {
        this.maxSalary = maxSalary;
    }

    public void setEmployeeCount(Long employeeCount) {
        this.employeeCount = employeeCount;
    }
}
