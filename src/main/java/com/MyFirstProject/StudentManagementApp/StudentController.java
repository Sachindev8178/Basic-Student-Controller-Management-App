package com.MyFirstProject.StudentManagementApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/student")
@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/welcome")
    public String getWel(){
        return "Welcome Students";
    }

    //to take inputs in ? int float double etc
    @GetMapping
    public Student getStudentById(@RequestParam("id")int id){
        return studentService.getStudentById(id);
    }

    //read or get the student by pathVariable
    @GetMapping("/id/{id}")
    public Student getStudentByPathVar(@PathVariable("id") int id){
        return studentService.getStudentByPathVar(id);
    }

    //to create the input
    @PostMapping
    public String addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    //Update the age using input PathVariable
    @PutMapping("/id/{id}/age/{age}")
    public String updateAgeByPathVar(@PathVariable("id")int id,
                                     @PathVariable("age") int age){
        return studentService.updateAgeByPathVar(id,age);
    }

    // Update Age using input RequestParam
    @PutMapping
    public String updateAgeByRequestParam(@RequestParam("id") int id,
                                          @RequestParam("age") int age){
        return studentService.updateAgeByRequestParam(id,age);
    }

    //Get the list of all Student
    @GetMapping("/all")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    //Delete a Student
    @DeleteMapping
    public String deleteStudent(@RequestParam("id") int id){
        return studentService.deleteStudent(id);
    }
}
