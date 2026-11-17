package com.example.CRUDspringBoot.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;

public class CreateStudentRequestDto {

    @NotBlank(message = "Name is REquired")
    @Size(min = 3, max = 20, message = "Name should be between 3 to 20 characters")
    private  String name;
    @Min(18)
    @NotNull(message = "Age is Required")
    private Integer age;
    @Email
    private String email;
    @NotNull
    private Integer rollNo;
    @NotBlank
    private  String subject;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
