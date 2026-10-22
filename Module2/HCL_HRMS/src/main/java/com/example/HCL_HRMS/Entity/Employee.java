package com.example.HCL_HRMS.Entity;

public class Employee {
    private Long emp_id;
    private String emp_name;
    private String designation;


    public Employee(Long emp_id, String emp_name, String designation, String progStrack, String email) {
        this.emp_id = (long) emp_id;
        this.emp_name = emp_name;
        this.designation = designation;
        this.progStrack = progStrack;
        this.email = email;
    }


    public Long getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(Long emp_id) {
        this.emp_id = emp_id;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getProgStrack() {
        return progStrack;
    }

    public void setProgStrack(String progStrack) {
        this.progStrack = progStrack;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String progStrack;
    private String email;
}
