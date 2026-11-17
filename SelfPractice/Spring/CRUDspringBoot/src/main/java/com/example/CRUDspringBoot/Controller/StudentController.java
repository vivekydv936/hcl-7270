package com.example.CRUDspringBoot.Controller;

import com.example.CRUDspringBoot.Entity.Student;
import com.example.CRUDspringBoot.Service.StudentService;
import com.example.CRUDspringBoot.dto.CreateStudentRequestDto;
import com.example.CRUDspringBoot.dto.CreateStudentResponseDto;
import com.example.CRUDspringBoot.dto.UpdateStudentRequestDto;
import com.example.CRUDspringBoot.dto.UpdateStudentResponseDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<CreateStudentResponseDto> createStudent(@RequestBody @Valid CreateStudentRequestDto studentRequestDto){

        CreateStudentResponseDto studentRes =studentService.createStudent(studentRequestDto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(studentRes);


    }

    // read one student

        @GetMapping("/get")
    public ResponseEntity<CreateStudentResponseDto> getSingleStudent(@RequestParam Long id){
        CreateStudentResponseDto studentRes = studentService.getSingleStudent(id);

        return ResponseEntity.ok(studentRes);

    }
    // read All student

    @GetMapping("/getAll")
    public ResponseEntity<List<CreateStudentResponseDto>> getAllStudent(){
        List<CreateStudentResponseDto> studentList = studentService.getAllStudent();

        return ResponseEntity.ok(studentList);

    }

    // update student

// read one student

    @PutMapping("/update")
    public ResponseEntity<UpdateStudentResponseDto> updateStudent(@RequestParam Long id, @RequestBody UpdateStudentRequestDto updateStudentRequestDto ){
        UpdateStudentResponseDto studentRes = studentService.UpdateStudent(id,updateStudentRequestDto);

        return ResponseEntity.ok(studentRes);

    }

    // delete student

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteStudent(@RequestParam Long id ){
        studentService.deleteStudent(id);

        return ResponseEntity.noContent().build();

    }

    @PatchMapping("/soft-delete")
    public ResponseEntity<String> softDelete(@RequestParam Long id){
        studentService.deletesoftly(id);

        return ResponseEntity.noContent().build();
    }

}
