package com.example.HCL_HRMS;

import com.example.HCL_HRMS.Entity.Employee;
import com.example.HCL_HRMS.Repository.EmployeeRepo;
import com.example.HCL_HRMS.Repository.EmployeeRepoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepoImp employeeRepoImp;

    public String addEmp(){
        Employee emp1 =new Employee(101L, "Rashu","FSD", "JAVA", "rashu@gmail.com");
        return employeeRepoImp.AddEmp(emp1);


    }




    public List<Employee> getEmp(){
        return employeeRepoImp.GetEmp();

    }

    public Employee getEmpById(Long id){
        return employeeRepoImp.getEmpById(id);
    }
}
