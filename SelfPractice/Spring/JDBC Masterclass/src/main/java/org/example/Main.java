package org.example;

import org.example.Model.Student;
import org.example.repository.StudentRepository;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        System.out.println("Hello World!");
        StudentRepository studentRepository = new StudentRepository();

   //     studentRepository.createStudent(new Student("Rohan", "rohan@gmail.com", 21));
    //  studentRepository.createStudent(new Student("Rohit Negi", "rohit@gmail.com", 8));

//       studentRepository.updateStudent(
//            new Student("Rohit Negi", "rohit@gmail.com", 26), 2L);

        //studentRepository.deleteStudent(9L);

//        studentRepository.getStudent();
    }
}
