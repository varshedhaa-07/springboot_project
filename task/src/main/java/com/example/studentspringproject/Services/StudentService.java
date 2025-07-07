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
<<<<<<< HEAD

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
=======
    List<Student> st = new ArrayList<>(Arrays.asList(new Student(1,"Ram",90),new Student(2,"John",75)));
    public List<Student> getStudent(){
        return st;
    }

    public Student getStudentById(int id) {
        int ind=0;
        boolean flag=false;
        for(int i=0;i<st.size();i++){
            if(id==st.get(i).getId()){
                ind=i;
                flag=true;
                break;
            }
        }
        if(flag){
            return st.get(ind);
        }else{
            return new Student();
        }
    }

    public String addStudent(Student stu) {
        st.add(stu);
        return "Added successfully";
    }

    public String updateStudent(Student stu) {
        int ind=0;
        boolean flag=false;
        for(int i=0;i<st.size();i++){
            if(stu.getId()==st.get(i).getId()){
                ind=i;
                flag=true;
                break;
            }
        }
        if(flag){
            st.set(ind,stu);
            return "Updated successfully";
        }else{
            return "Student not found";
        }
    }

    public String deleteStudent(int id) {
        int ind=0;
        boolean flag=false;
        for(int i=0;i<st.size();i++){
            if(id==st.get(i).getId()){
                ind =i;
                flag=true;
                break;
            }
        }
        if(flag){
            st.remove(ind);
            return "Deleted successfully";
        }else{
            return "Student not found";
        }
>>>>>>> ba48aa4f910995872230319f1f04e2fabb1aae28
    }

    public String deleteStudent(int id) {
        stuRepo.deleteById(id);
        return "Student Deleted successfully";
    }

}
