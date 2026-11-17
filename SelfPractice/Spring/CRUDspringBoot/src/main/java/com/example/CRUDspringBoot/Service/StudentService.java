package com.example.CRUDspringBoot.Service;


import com.example.CRUDspringBoot.Entity.Student;
import com.example.CRUDspringBoot.Exceptions.DuplicateResourceException;
import com.example.CRUDspringBoot.Exceptions.ResourceNotFoundException;
import com.example.CRUDspringBoot.Repository.StudentRepository;
import com.example.CRUDspringBoot.dto.CreateStudentRequestDto;
import com.example.CRUDspringBoot.dto.CreateStudentResponseDto;
import com.example.CRUDspringBoot.dto.UpdateStudentRequestDto;
import com.example.CRUDspringBoot.dto.UpdateStudentResponseDto;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service

public class StudentService {
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){

        this.studentRepository =studentRepository;
    }

 public CreateStudentResponseDto createStudent(CreateStudentRequestDto StudentRequestDto){
            // business logic // validation// processing input data

        Student studentToSave = maptoEntity(StudentRequestDto);
        // Email Alredy exists check
            if(EmailExists(studentToSave)){
                throw new DuplicateResourceException("Email with "+studentToSave.getEmail()+" already exists");
            }

       Student studeRes= studentRepository.save(studentToSave);
       CreateStudentResponseDto studentres = maptoDto(studeRes);
       return studentres;
 }


 public CreateStudentResponseDto getSingleStudent(Long id){
      Student studentRes = studentRepository
              .findByIdAndIsDeletedFalse(id)
              .orElseThrow(()-> new ResourceNotFoundException("Student with id "+id+" not found"));

          return maptoDto(studentRes);

 }

    public List<CreateStudentResponseDto> getAllStudent(){
     return studentRepository.findByIsDeletedFalse()
             .stream()
             .map(this::maptoDto)
             .toList();
 }

    public UpdateStudentResponseDto UpdateStudent(Long id, UpdateStudentRequestDto updateStudentRequestDto){
        Student ExistingStudent = studentRepository.findByIdAndIsDeletedFalse(id)
                .orElseThrow(()-> new ResourceNotFoundException("Student with id "+id+" not found"));



        ExistingStudent.setName(updateStudentRequestDto.getName());
        ExistingStudent.setAge(updateStudentRequestDto.getAge());
        ExistingStudent.setRollNo(updateStudentRequestDto.getRollNo());
        ExistingStudent.setSubject(updateStudentRequestDto.getSubject());
        ExistingStudent.setDeleted(false);
        ExistingStudent.setUpdatedAt(LocalDateTime.now());
        Student savedStd = studentRepository.save(ExistingStudent);
        UpdateStudentResponseDto res =maptoUpdatedDto(savedStd);
        return res;
    }

    public void deleteStudent(Long id){
       Student studentToDelete = studentRepository.findById(id).
                orElseThrow(()-> new ResourceNotFoundException("Student with id "+id+" not found"));
        // If we reach here, the student exists
        studentRepository.delete(studentToDelete);

    }

    public void deletesoftly(Long id){
        //get
        Student studentToDelete = studentRepository.findByIdAndIsDeletedFalse(id).
                orElseThrow(()-> new ResourceNotFoundException("Student with id "+id+" not found"));

/*       set IsDeleted =1;*/


       //save
        studentToDelete.setDeleted(true);
       studentRepository.save(studentToDelete);


    }

    private Student maptoEntity(CreateStudentRequestDto studentRequestDto){
        Student student = new Student();
        student.setName(studentRequestDto.getName());
        student.setAge(studentRequestDto.getAge());
        student.setRollNo(studentRequestDto.getRollNo());
        student.setEmail(studentRequestDto.getEmail());
        student.setSubject(studentRequestDto.getSubject());
        student.setCreatedAt(LocalDateTime.now());
        student.setUpdatedAt(LocalDateTime.now());
        return student;
    }

    private CreateStudentResponseDto maptoDto(Student student){
        CreateStudentResponseDto studentResDto = new CreateStudentResponseDto();
        studentResDto.setId(student.getId());
        studentResDto.setName(student.getName());
        studentResDto.setAge(student.getAge());
        studentResDto.setRollNo(student.getRollNo());
        studentResDto.setEmail(student.getEmail());
        studentResDto.setSubject(student.getSubject());
        studentResDto.setCreatedAt(student.getCreatedAt());
        studentResDto.setUpdatedAt(student.getUpdatedAt());
        studentResDto.setMessage("Student created successfully");
        return studentResDto;
    }

    private UpdateStudentResponseDto maptoUpdatedDto(Student student){
        UpdateStudentResponseDto studentResDto = new UpdateStudentResponseDto();
        studentResDto.setId(student.getId());
        studentResDto.setName(student.getName());
        studentResDto.setAge(student.getAge());
        studentResDto.setRollNo(student.getRollNo());
        studentResDto.setEmail(student.getEmail());
        studentResDto.setSubject(student.getSubject());
        studentResDto.setUpdatedAt(student.getUpdatedAt());
        studentResDto.setMessage("Student updated successfully");
        return studentResDto;
    }

    private boolean EmailExists(Student student){
        return studentRepository.existsByEmail(student.getEmail());
    }

}
