package com.example.HCL_HRMS.Controller;


import com.example.HCL_HRMS.EmployeeService;
import com.example.HCL_HRMS.Entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
        @GetMapping("/")
        public String welcome(){
            return "welcome to HRMS";
        }


        @GetMapping("/addemp")
        public String AddEmployee(){
            return employeeService.addEmp();
        }

        @GetMapping("/getemp")
        public List<Employee> getEmployee(){
             return employeeService.getEmp();

        }

        @GetMapping("/getemp/{id}")
        public Employee getbyid( @PathVariable Long id){
       Employee emp= employeeService.getEmpById(id);
       return emp;
        }


}
