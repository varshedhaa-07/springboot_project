package com.example.studentspringproject.controllers;

import com.example.studentspringproject.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    com.example.studentspringproject.Services.StudentService s;
    @GetMapping
    public List<Student> getMethod(){
        return s.getMethod();
    }

    @PostMapping("/")
    public void postMethod(@RequestBody Student stu){
         s.postMethod(stu);
    }

    @PutMapping
    public String putMethod(){
        return s.putMethod();
    }

    @DeleteMapping
    public String deleteMethod(){
        return s.deleteMethod();
    }
}
