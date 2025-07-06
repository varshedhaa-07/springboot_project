package com.example.studentspringproject.controllers;

import com.example.studentspringproject.Services.StudentService;
import com.example.studentspringproject.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stu")
public class StudentController {
    @Autowired
    private StudentService s;

    @GetMapping
    public List<Student> getStudent(){
        return s.getStudent();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id){
        return s.getStudentById(id);
    }

    @PostMapping
    public String addStudent(@RequestBody Student stu){
         return s.addStudent(stu);
    }

    @PutMapping
    public String updateStudent(@RequestBody Student stu){
        return s.updateStudent(stu);
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id){
        return s.deleteStudent(id);
    }
}
