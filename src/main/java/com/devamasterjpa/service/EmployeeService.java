package com.devamasterjpa.service;

import com.devamasterjpa.dto.SalaryDistributionDTO;
import com.devamasterjpa.models.Employee;
import com.devamasterjpa.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    public void createEmployee(Employee employee) {
      employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    public List<Employee> getAllEmployeeByName(String name) {
        return employeeRepository.findByEmpName(name);
    }

    public Employee findByEmail(String name) {
        return employeeRepository.findByEmpEmail(name).orElse(null);
    }

    public List<Employee> findByEmpSalaryGreaterThan(Double salary){
        return employeeRepository.findByEmpSalaryGreaterThan(salary);
    }

    public Long countEmployeesByDesignation(String designation) {
        return employeeRepository.countByEmpDesignation(designation);
    }
    public List<Employee> findByEmpSalaryLessThan(Double salary){
        return employeeRepository.findEmployeesWithSalaryLessThan(salary);
    }


    public List<Employee> findEmployeesWithBetterThanAverageRank(){
        return employeeRepository.findEmployeesWithBetterThanAverageRank();
    }
    

    public List<Employee> findEmployeesWithHigherThanAverageSalaryInDesignation(){
        return employeeRepository.findEmployeesWithBetterThanAverageRank();
    }

    public List<SalaryDistributionDTO> getSalaryDistributionByDesignation() {
        List<Object[]> results = employeeRepository.getSalaryDistributionByDesignation();
        List<SalaryDistributionDTO> salaryDistributions = new ArrayList<>();

        for (Object[] result : results) {
            String designation = (String) result[0];

            // Handle different numeric types that might be returned by different databases
            BigDecimal minSalary = convertToBigDecimal(result[1]);
            BigDecimal maxSalary = convertToBigDecimal(result[2]);
            BigDecimal avgSalary = convertToBigDecimal(result[3]);

            Long count = ((Number) result[4]).longValue();

            SalaryDistributionDTO dto = new SalaryDistributionDTO(
                    designation, minSalary, maxSalary, avgSalary, count
            );
            salaryDistributions.add(dto);
        }

        return salaryDistributions;
    }
    private BigDecimal convertToBigDecimal(Object value) {
        if (value == null) {
            return null;
        }

        if (value instanceof BigDecimal) {
            return (BigDecimal) value;
        } else if (value instanceof Double) {
            return BigDecimal.valueOf((Double) value);
        } else if (value instanceof Float) {
            return BigDecimal.valueOf((Float) value);
        } else if (value instanceof Integer) {
            return BigDecimal.valueOf((Integer) value);
        } else if (value instanceof Long) {
            return BigDecimal.valueOf((Long) value);
        } else if (value instanceof String) {
            return new BigDecimal((String) value);
        }

        throw new IllegalArgumentException("Cannot convert " + value.getClass().getName() + " to BigDecimal");
    }


    public Employee findEmployeeWithHighestSalary() {
        return employeeRepository.findEmployeeWithHighestSalary();
    }
}
