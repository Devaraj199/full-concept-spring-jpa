package com.devamasterjpa.repository;

import com.devamasterjpa.models.Employee;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByEmpName(String empName);
    Optional<Employee> findByEmpEmail(String empEmail);
    List<Employee> findByEmpSalaryGreaterThan(Double salary);
    Long countByEmpDesignation(String empDesignation);

    @Query("SELECT emp from Employee emp where emp.empSalary < :salary")
    List<Employee> findEmployeesWithSalaryLessThan(@Param("salary") Double salary);

    @Query("SELECT e FROM Employee e WHERE e.empDesignation = :designation")
    List<Employee> findEmployeesByDesignation(@Param("designation") String designation);

    @Query("SELECT e FROM Employee e order by empSalary desc limit 1")
    Employee findEmployeeWithHighestSalary();

    // Find employees with better than average rank (lower is better)

     @Query("SELECT e FROM Employee e where e.empRank < (SELECT AVG(e2.empRank) FROM Employee e2)")
     List<Employee> findEmployeesWithBetterThanAverageRank();

    // Find employees with salary higher than others in same designation
    @Query("SELECT e FROM Employee e WHERE e.empSalary > " +
            "(SELECT AVG(e2.empSalary) FROM Employee e2 WHERE e2.empDesignation = e.empDesignation)")
    List<Employee> findEmployeesWithHigherThanAverageSalaryInDesignation();

    @Query(value = "SELECT e.emp_designation, " +
            "MIN(e.emp_salary) as min_salary, " +
            "MAX(e.emp_salary) as max_salary, " +
            "AVG(e.emp_salary) as avg_salary, " +
            "COUNT(*) as employee_count " +
            "FROM emp_table e " +
            "GROUP BY e.emp_designation " +
            "ORDER BY avg_salary ASC",
            nativeQuery = true)
    List<Object[]> getSalaryDistributionByDesignation();


}
