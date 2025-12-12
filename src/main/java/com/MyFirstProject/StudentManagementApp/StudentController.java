package com.MyFirstProject.StudentManagementApp;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RequestMapping("/api/v1")
@RestController
public class StudentController {
    HashMap<Integer,Student>studentDb=new HashMap<>();

    @GetMapping("/welcome")
    public String getWel(){
        return "Welcome Students";
    }

    //to take inputs in int float double etc
    @GetMapping("/student")
    public Student getStudentById(@RequestParam("id")int id){
        if(!studentDb.containsKey(id)){
            return null;
        }
        return studentDb.get(id);
    }

    //to take complete object body inputs
    @PostMapping("/student")
    public  String addStudent(@RequestBody Student student){
        if(studentDb.containsKey(student.getId())){
            return  "Student Already Added";
        }
        studentDb.put(student.getId(),student);

        return "Student Added Successfully";
    }

    //To take single variable input
    @GetMapping("/student/{id}")
    public Student getStudentByIdPath(@PathVariable("id") int id){
        if(!studentDb.containsKey(id)){
            return null;
        }
        return studentDb.get(id);
    }

    //update age
    @PutMapping("/student/id/{id}/age/{age}")
    public String updateAge(@PathVariable("id") int id,
                            @PathVariable("age") int age){
        if(!studentDb.containsKey(id)){
            return "Invalid Age";
        }
        Student existingAge=studentDb.get(id);
        existingAge.setAge(age);
        studentDb.put(id,existingAge);
        return "Age Updated Successfully";
    }
}
