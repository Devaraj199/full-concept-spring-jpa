package com.devamasterjpa.service;

import com.devamasterjpa.dto.DepartmentEmployeeCountDTO;
import com.devamasterjpa.dto.DepartmentHighestAvgSalaryDTO;
import com.devamasterjpa.dto.DeptAvgSalaryDto;
import com.devamasterjpa.dto.EmpDeptDto;
import com.devamasterjpa.repository.EmpDeptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpDeptService {
    @Autowired
    EmpDeptRepository empDeptRepository;
    public List<EmpDeptDto> getEmpWithDept() {
        return empDeptRepository.getEmpWithDept();
    }

    public List<EmpDeptDto> findEmployeesByDepartmentName(String deptName) {
        return empDeptRepository.findEmployeesByDepartmentName(deptName);
    }

    public List<DeptAvgSalaryDto> findDepartmentAverageSalaries(){
        return empDeptRepository.findDepartmentAverageSalaries();
    }

    public List<DepartmentEmployeeCountDTO> getDepartmentEmployeeCount(){
        return empDeptRepository.getDepartmentEmployeeCount();
    }

    public Object[] getDepartmentWithHighestAvgSalary(){
        Pageable pageable = PageRequest.of(0, 1);
        List<Object[]> results = empDeptRepository.getDepartmentWithHighestAvgSalary(pageable);
        if(!results.isEmpty()){
            return results.get(0);
        }
        return  null;
    }

   public void updateEmployeeRankByEmail(String email,Integer rank){
        empDeptRepository.updateEmployeeRankByEmail(email,rank);
   }


}
