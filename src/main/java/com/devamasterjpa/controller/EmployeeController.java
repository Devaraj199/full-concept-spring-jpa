package com.devamasterjpa.controller;
import com.devamasterjpa.dto.SalaryDistributionDTO;
import com.devamasterjpa.models.Employee;
import com.devamasterjpa.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;
    @PostMapping("/add")
    public ResponseEntity<String> createEmployee(@RequestBody Employee employee){
        this.employeeService.createEmployee(employee);
        return ResponseEntity.ok("Employee created");
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployee(){
        System.out.println(employeeService.getAllEmployee());
      return ResponseEntity.ok(employeeService.getAllEmployee());
    }

    @GetMapping("/{empName}")
    public ResponseEntity<List<Employee>> getAllEmployeeByName(@PathVariable String empName){
        return ResponseEntity.ok(employeeService.getAllEmployeeByName(empName));
    }

    @GetMapping("/email/{empMail}")
    public ResponseEntity<Employee> getEmployeeByEmail(@PathVariable String empMail) {
        Employee byEmail = employeeService.findByEmail(empMail);
        return ResponseEntity.ok(byEmail);
    }
//
//    @GetMapping("/salary/{empSalary}")
//    public ResponseEntity<List<Employee>> findByEmpSalaryGreaterThan(@PathVariable Double  empSalary) {
//        return ResponseEntity.ok(employeeService.findByEmpSalaryGreaterThan(empSalary));
//    }

    @GetMapping("/des/{designation}")
    public ResponseEntity<Long> countEmployeesByDesignation(@PathVariable  String designation) {
        return ResponseEntity.ok(employeeService.countEmployeesByDesignation(designation));
    }

    @GetMapping("/salary/{empSalary}")
    public ResponseEntity<List<Employee>> getEmployeeByEmail(@PathVariable Double  empSalary) {
        return ResponseEntity.ok(employeeService.findByEmpSalaryLessThan(empSalary));
    }

    @GetMapping("/rank")
    public ResponseEntity<List<Employee>> findEmployeesWithBetterThanAverageRank(){
        return ResponseEntity.ok(employeeService.findEmployeesWithBetterThanAverageRank());
    }

    @GetMapping("/higherThanAvg")
    public ResponseEntity<List<Employee>> findEmployeesWithHigherThanAverageSalaryInDesignation(){
        return ResponseEntity.ok(employeeService.findEmployeesWithHigherThanAverageSalaryInDesignation());
    }

    @GetMapping("/salary-distribution")
    public ResponseEntity<List<SalaryDistributionDTO>> getSalaryDistributionByDesignation() {
        List<SalaryDistributionDTO> salaryDistributions = employeeService.getSalaryDistributionByDesignation();
        return ResponseEntity.ok(salaryDistributions);
    }

    @GetMapping("/highest-salary")
    public ResponseEntity<Employee> findEmployeeWithHighestSalary() {
        return ResponseEntity.ok(employeeService.findEmployeeWithHighestSalary());
    }




}
