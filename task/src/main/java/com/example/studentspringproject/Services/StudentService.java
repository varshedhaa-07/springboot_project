package com.example.studentspringproject.Services;

import com.example.studentspringproject.models.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class StudentService {
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
    }
}
