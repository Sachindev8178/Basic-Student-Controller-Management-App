package com.MyFirstProject.StudentManagementApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;
    public Student getStudentById(int id){
        return studentRepository.findById(id).orElse(null);
    }

    public String addStudent(Student student) {
        if (studentRepository.existsById(student.getId())) {
            return "Student Already Added";
        }
        studentRepository.save(student);
        return "new Student Added";
    }

    public Student getStudentByPathVar(int id) {
        return studentRepository.findById(id).orElse(null);
    }

    public String updateAgeByPathVar(int id, int age) {
        return updateAge(id, age);
    }

    public String updateAgeByRequestParam(int id, int age) {
        return updateAge(id, age);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public String deleteStudent(int id) {
        if (!studentRepository.existsById(id)) {
            return "Invalid Id";
        }
        studentRepository.deleteById(id);
        return "Delete Student Successfully";
    }

    private String updateAge(int id, int age) {
        return studentRepository.findById(id)
                .map(existingStudent -> {
                    existingStudent.setAge(age);
                    studentRepository.save(existingStudent);
                    return "Age Updated Successfully";
                })
                .orElse("Invalid Id");
    }
}
