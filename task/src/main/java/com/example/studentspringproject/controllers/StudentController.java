package com.example.studentspringproject.controllers;

import com.example.studentspringproject.Services.StudentService;
import com.example.studentspringproject.models.Student;
import com.example.studentspringproject.repository.StudentRepository;
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

<<<<<<< HEAD
    @GetMapping("/{EmpId}")
=======
    @GetMapping("/{id}")
>>>>>>> ba48aa4f910995872230319f1f04e2fabb1aae28
    public Student getStudentById(@PathVariable int id){
        return s.getStudentById(id);
    }

<<<<<<< HEAD
    @PostMapping("/")
    public String addStudent(@RequestBody Student stu){
          return s.addStudent(stu);
=======
    @PostMapping
    public String addStudent(@RequestBody Student stu){
         return s.addStudent(stu);
>>>>>>> ba48aa4f910995872230319f1f04e2fabb1aae28
    }

    @PutMapping
    public String updateStudent(@RequestBody Student stu){
        return s.updateStudent(stu);
    }

<<<<<<< HEAD
    @DeleteMapping
=======
    @DeleteMapping("/{id}")
>>>>>>> ba48aa4f910995872230319f1f04e2fabb1aae28
    public String deleteStudent(@PathVariable int id){
        return s.deleteStudent(id);
    }
}
