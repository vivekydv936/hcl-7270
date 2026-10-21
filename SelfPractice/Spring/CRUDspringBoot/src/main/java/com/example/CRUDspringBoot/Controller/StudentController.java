package com.example.CRUDspringBoot.Controller;

import com.example.CRUDspringBoot.Entity.Student;
import com.example.CRUDspringBoot.Service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/students")


public class StudentController {

   private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // create student
    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
//        System.out.println("inside student controller");
        student.setDeleted(false);
       Student createdStudent= studentService.createStudent(student);
//        System.out.println("exiting student controller");
       return  ResponseEntity
               .status(HttpStatus.CREATED)
               .body(createdStudent);

    }

    // read one student

        @GetMapping("/get/{id}")
    public ResponseEntity<Student> getSingleStudent(@PathVariable Long id){
        Student studentRes = studentService.getSingleStudent(id);
        if(studentRes==null){
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentRes);

    }
    // read All student

    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> getAllStudent(){
        List<Student> studentList = studentService.getAllStudent();
        if(studentList.isEmpty()){
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentList);

    }

    // update student

// read one student

    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student studentreq ){
        Student studentRes = studentService.UpdateStudent(id,studentreq);
        if(studentRes==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentRes);

    }

    // delete student

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id ){
        Boolean isdeleted =studentService.deleteStudent(id);
        if(!isdeleted){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Student deleted Successfully");

    }

}
