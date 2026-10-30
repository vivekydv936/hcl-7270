package org.abes.HrmaDataBase.service;

import org.abes.HrmaDataBase.model.Employee;
import org.abes.HrmaDataBase.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public String createnewEmployee(Employee newEmp){

        employeeRepository.save(newEmp);

        return "Employees are added successfully";
    }


    public Employee getEmployeeById(long empid){
        return employeeRepository.findById(empid).orElse(null);
    }

    public Employee updateEmployee(long empid, Employee updatedEmployee){
        Employee employee = employeeRepository.findById(empid).orElse(null);
        if (employee == null) {
            return null;
        }

        employee.setName(updatedEmployee.getName());
        employee.setEmail(updatedEmployee.getEmail());
        employee.setDesignation(updatedEmployee.getDesignation());
        employee.setTechStack(updatedEmployee.getTechStack());
        employee.setPassword(updatedEmployee.getPassword());
        return employeeRepository.save(employee);
    }

    public Employee DeleteById(long empid){
        Employee employee = employeeRepository.findById(empid).orElse(null);
        if (employee != null) {
            employeeRepository.deleteById(empid);
        }
        return employee;
    }
}
