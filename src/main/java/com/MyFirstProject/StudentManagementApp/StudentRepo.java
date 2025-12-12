package com.MyFirstProject.StudentManagementApp;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class StudentRepo {
    HashMap<Integer,Student> studentDb=new HashMap<>();

    public Student getStudentById(int id){
        if(!studentDb.containsKey(id)){
            return null;
        }
        return studentDb.get(id);
    }

    public String addStudent(Student student) {
        if(studentDb.containsKey(student.getId())){
            return "Student Already Added";
        }
        studentDb.put(student.getId(),student);
        return "new Student Added";
    }

    public Student getStudentByPathVar(int id) {
        if(!studentDb.containsKey(id)){
            return null;
        }
        return studentDb.get(id);
    }

    public String updateAgeByPathVar(int id, int age) {
        if(!studentDb.containsKey(id)){
            return "Invalid Id";
        }

        Student existingStudent=studentDb.get(id);
        existingStudent.setAge(age);
        studentDb.put(id,existingStudent);
        return "Age Added Successfully";
    }

    public String updateAgeByRequestParam(int id, int age) {
        if(!studentDb.containsKey(id)){
            return "Invalid Id";
        }
        Student existingStudent=studentDb.get(id);
        existingStudent.setAge(age);
        studentDb.put(id,existingStudent);
        return "Age Updated Successfully";
    }

    public List<Student> getAllStudents() {
        ArrayList<Student>students=new ArrayList<>();
        for(Student student:studentDb.values()){
            students.add(student);
        }
        return students;

    }

    public String deleteStudent(int id) {
        if(!studentDb.containsKey(id)){
            return "Invalid Id";
        }
        else{
            studentDb.remove(id);
            return "Delete Student Successfully";
        }
    }
}
