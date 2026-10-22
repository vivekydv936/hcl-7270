package com.example.HCL_HRMS.Repository;

import com.example.HCL_HRMS.Entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepoImp implements EmployeeRepo {


    List<Employee> empList =new ArrayList<>();






    @Override
    public String AddEmp(Employee emp) {
        empList.add(emp);
        return "Employee added";

    }

    @Override
    public List<Employee> GetEmp() {

        return empList;
    }

    @Override
    public Employee getEmpById(long empid) {
        return empList.stream().filter(e->e.getEmp_id()==empid).findFirst().orElse(null);

    }

    @Override
    public String addEmpBulk(List<Employee> bulkemp){
      List<Employee> empList4=   List.of(new Employee(4L,"Yash","Test Developer","Spring Boot","yash@gmail.com"));
        List<Employee> empList1=   List.of(new Employee(1L,"rahul","Test Engineer","Spring","rahul@gmail.com"));

        List<Employee> empList2=   List.of(new Employee(2L,"arun","Fulll Stack","mern","arun@gmail.com"));

        List<Employee> empList3=   List.of(new Employee(3L,"saurav","AIML","Paython","saurav@gmail.com"));

        return "";
    }


    @Override
    public String deleteById(long empid) {
        return "";
    }

    @Override
    public String updateById(long empid, Employee employeeUdate) {
        return "";
    }
}
