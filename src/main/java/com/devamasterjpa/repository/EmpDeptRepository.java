package com.devamasterjpa.repository;

import com.devamasterjpa.dto.DepartmentEmployeeCountDTO;
import com.devamasterjpa.dto.DeptAvgSalaryDto;
import com.devamasterjpa.dto.EmpDeptDto;
import com.devamasterjpa.models.Employee;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EmpDeptRepository extends JpaRepository<Employee,Long> {

    @Query("SELECT new com.devamasterjpa.dto.EmpDeptDto(e.empName, d.deptName, e.empDesignation,e.empSalary ) " +
            "FROM Employee e JOIN e.department d")
    List<EmpDeptDto> getEmpWithDept();

        @Query("SELECT new com.devamasterjpa.dto.EmpDeptDto(e.empName, d.deptName, e.empDesignation,e.empSalary) " +
            "FROM Employee e JOIN e.department d " +
            "WHERE d.deptName = :departmentName")
                // Native query
//        @Query(value = "SELECT e.emp_name, d.dept_name, e.emp_designation,e.emp_salary " +
//                "FROM emp_table e JOIN department d ON e.dept_id = d.dept_id " +
//                "WHERE d.dept_name = :departmentName",
//                nativeQuery = true)
            List<EmpDeptDto> findEmployeesByDepartmentName(@Param("departmentName") String departmentName);

    @Query("SELECT new com.devamasterjpa.dto.DeptAvgSalaryDto(d.deptName, AVG(e.empSalary)) " +
            "FROM Employee e JOIN e.department d " +
            "GROUP BY d.deptName " +
            "ORDER BY AVG(e.empSalary) DESC")
    List<DeptAvgSalaryDto> findDepartmentAverageSalaries();

    @Query("SELECT new com.devamasterjpa.dto.DepartmentEmployeeCountDTO(d.deptName, COUNT(e.empId)) " +
            "FROM Employee e JOIN e.department d " +
            "GROUP BY d.deptName")
    List<DepartmentEmployeeCountDTO> getDepartmentEmployeeCount();

    @Query("SELECT d.deptName, AVG(e.empSalary) " +
            "FROM Employee e JOIN e.department d " +
            "GROUP BY d.deptName " +
            "ORDER BY AVG(e.empSalary) DESC")
    List<Object[]> getDepartmentWithHighestAvgSalary(Pageable pageable);
    @Modifying
    @Transactional
    @Query("UPDATE Employee e SET e.empRank = :empRank WHERE e.empEmail = :empEmail")
    void updateEmployeeRankByEmail(@Param("empEmail") String empEmail, @Param("empRank") Integer empRank);
}
