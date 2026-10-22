package com.example.CRUDspringBoot.Service;


import com.example.CRUDspringBoot.Controller.StudentController;
import com.example.CRUDspringBoot.Entity.Student;
import com.example.CRUDspringBoot.Repository.StudentRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class StudentService {
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){

        this.studentRepository =studentRepository;
    }

 public Student createStudent(Student studentReq){
            // business logic // validation// processing input data
//     System.out.println("inside student service");
        Student studentResponse =studentRepository.save(studentReq);
//     System.out.println("exiting student service");

        return studentResponse;
 }


 public Student getSingleStudent(Long id){
      Optional<Student> studentRes = studentRepository.findByIdAndIsDeletedFalse(id);
      if(studentRes.isPresent()){
          return studentRes.get();
      }
      else return null;
 }

    public List<Student> getAllStudent(){
        List<Student> studentList = studentRepository.findByIsDeletedFalse();
       return studentList;
    }

    public Student UpdateStudent(Long id,Student studentReq){
        Optional<Student> ExistingStudent = studentRepository.findByIdAndIsDeletedFalse(id);
        if(ExistingStudent.isEmpty()){
            return null;
        }
        Student studentToSave =ExistingStudent.get();

        studentToSave.setName(studentReq.getName());
        studentToSave.setAge(studentReq.getAge());
        studentToSave.setRollNo(studentReq.getRollNo());
        studentToSave.setEmail(studentReq.getEmail());
        studentToSave.setSubject(studentReq.getSubject());
        studentToSave.setDeleted(false);
        return studentRepository.save(studentToSave);
    }

    public Boolean deleteStudent(Long id){
        Boolean isExists =studentRepository.existsById(id);
        if(!isExists) return false;
        studentRepository.deleteById(id);
        return true;
    }

    public Boolean deletesoftly(Long id){
        //get
       Optional<Student> existingStudent = studentRepository.findByIdAndIsDeletedFalse(id);
       if(existingStudent.isEmpty()) return false;

/*       set IsDeleted =1;*/

       Student studentTosave= existingStudent.get();
       //save
       studentTosave.setDeleted(true);
       studentRepository.save(studentTosave);
       return true;

    }


}
