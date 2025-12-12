package com.MyFirstProject.StudentManagementApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepo studentRepo;
    public Student getStudentById(int id){
        return studentRepo.getStudentById(id);
    }

    public String addStudent(Student student) {
        return studentRepo.addStudent(student);
    }

    public Student getStudentByPathVar(int id) {
        return studentRepo.getStudentByPathVar(id);
    }

    public String updateAgeByPathVar(int id, int age) {
        return studentRepo.updateAgeByPathVar(id,age);
    }

    public String updateAgeByRequestParam(int id, int age) {
        return studentRepo.updateAgeByRequestParam(id,age);
    }

    public List<Student> getAllStudents() {
        return studentRepo.getAllStudents();
    }

    public String deleteStudent(int id) {
        return studentRepo.deleteStudent(id);
    }
}
