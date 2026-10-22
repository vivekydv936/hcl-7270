package com.example.HCL_HRMS.Repository;


import com.example.HCL_HRMS.Entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo {

    public String AddEmp(Employee emp);

    List<Employee> GetEmp();
    Employee getEmpById(long empid);

    String addEmpBulk(List<Employee> bulkemp);

    String deleteById(long empid);
    String updateById(long empid,Employee employeeUdate);






}
