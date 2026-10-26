package org.example.controller;


import org.example.entity.Student;
import org.example.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService =studentService;
    }


    @PostMapping("/create")
    public Student createStudent(@RequestBody Student studentReq){
        Student studentRes =studentService.createStudent(studentReq);
        return studentRes;
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Student> getSingleStudent(@PathVariable("id") Long id){
        Student stdRes =studentService.getStudent(id);
        if(stdRes==null){
            return ResponseEntity.notFound().build();
        }
        else{
            return ResponseEntity.ok(stdRes);
        }
    }

    @GetMapping("/getall")
    public ResponseEntity<List<Student>> getStudents(){
        List<Student> stdRes =studentService.getAllStudent();

            return ResponseEntity.ok(stdRes);

    }

}
