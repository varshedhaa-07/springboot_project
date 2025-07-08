package com.example.studentspringproject.Services;

import com.example.studentspringproject.models.Student;
import com.example.studentspringproject.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository stuRepo;
    public List<Student> getMethod(){
        return stuRepo.findAll();
    }

    public Student getStudentById(int id) {
        return stuRepo.findById(id).orElse(new Student());
    }

    public String addStudent(Student stu) {
        stuRepo.save(stu);
        return "Student Added successfully";
    }

    public String updateStudent(Student stu) {
        stuRepo.save(stu);
        return "Student Updated successfully";
    }

    public String deleteStudent(int id) {
        stuRepo.deleteById(id);
        return "Student Deleted successfully";
    }

}
