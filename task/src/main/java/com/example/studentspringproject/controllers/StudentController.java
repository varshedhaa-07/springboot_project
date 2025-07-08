package com.example.studentspringproject.controllers;

import com.example.studentspringproject.models.Student;
import com.example.studentspringproject.repository.StudentRepository;
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

    @GetMapping("/{EmpId}")
    public Student getStudentById(@PathVariable int id){
        return s.getStudentById(id);
    }

    @PostMapping("/")
    public String addStudent(@RequestBody Student stu){
          return s.addStudent(stu);
    }

    @PutMapping
    public String updateStudent(@RequestBody Student stu){
        return s.updateStudent(stu);
    }

    @DeleteMapping
    public String deleteStudent(@PathVariable int id){
        return s.deleteStudent(id);
    }
}
