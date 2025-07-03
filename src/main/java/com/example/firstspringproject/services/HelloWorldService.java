package com.example.firstspringproject.services;

import com.example.firstspringproject.models.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class HelloWorldService {
    List<Employee> e=new ArrayList<>(Arrays.asList(new Employee(1,"John","Trainer"),new Employee(2,"David","Faculty"))
    );

    public List<Employee> getMethod() {
        return e;
    }

    public void postMethod(Employee emp) {
        e.add(emp);
    }

    public String putMethod() {
        return "This is put method";
    }

    public String deleteMethod() {
        return "This is delete method";
    }
}
