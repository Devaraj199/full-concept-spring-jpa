package com.devamasterjpa.controller;

import com.devamasterjpa.dto.DepartmentEmployeeCountDTO;
import com.devamasterjpa.dto.DeptAvgSalaryDto;
import com.devamasterjpa.dto.EmpDeptDto;
import com.devamasterjpa.service.EmpDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/emp_dept")
public class EmployeeDepartmentController {

    @Autowired
    EmpDeptService empDeptService;
    @GetMapping
    public ResponseEntity<List<EmpDeptDto>> getEmpWithDept(){
        return ResponseEntity.ok(empDeptService.getEmpWithDept());
    }

    @GetMapping("/{deptName}")
    public ResponseEntity<List<EmpDeptDto>> getEmpWithDept(@PathVariable("deptName") String deptName){
        return ResponseEntity.ok(empDeptService.findEmployeesByDepartmentName(deptName));
    }

    @GetMapping("/dept/avgsalary")
    public ResponseEntity<List<DeptAvgSalaryDto>> findDepartmentAverageSalaries(){
        return ResponseEntity.ok(empDeptService.findDepartmentAverageSalaries());
    }

    @GetMapping("/count/emp_count")
    public ResponseEntity<List<DepartmentEmployeeCountDTO>> getDepartmentEmployeeCount(){
        return ResponseEntity.ok(empDeptService.getDepartmentEmployeeCount());
    }

    @GetMapping("/highest/avg_salary")
    public ResponseEntity<Object[]> getDepartmentWithHighestAvgSalary(){
        return ResponseEntity.ok(empDeptService.getDepartmentWithHighestAvgSalary());
    }

    @PutMapping("/employees/rank")
    public ResponseEntity<String> updateEmployeeRankByEmail(
            @RequestParam String email,
            @RequestParam int rank) {
        empDeptService.updateEmployeeRankByEmail(email, rank);
        return ResponseEntity.ok("Updated successfully");
    }



}
