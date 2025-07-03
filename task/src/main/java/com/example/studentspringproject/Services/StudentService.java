package com.example.studentspringproject.Services;

import com.example.studentspringproject.models.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class StudentService {
    List<Student> st = new ArrayList<>(Arrays.asList(new Student(1,"Ram",90),new Student(2,"John",75)));
    public List<Student> getMethod(){
        return st;
    }

    public void postMethod(Student stu) {
        st.add(stu);
    }

    public String putMethod() {
        return "This is put method";
    }

    public String deleteMethod() {
        return "This is delete method";
    }
}
