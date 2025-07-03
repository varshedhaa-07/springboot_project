package com.example.firstspringproject.controllers;

import com.example.firstspringproject.models.Employee;
import com.example.firstspringproject.services.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HelloWorldController {
    @Autowired
    private HelloWorldService hws;
    @GetMapping("/")
    public List<Employee> getMethod(){
        return hws.getMethod();
    }

    @PostMapping("/")
    public void postMethod(Employee emp){
        hws.postMethod(emp);
    }

    @PutMapping("/")
    public String putMethod(){
        return hws.putMethod();
    }

    @DeleteMapping("/")
    public String deleteMethod(){
        return hws.deleteMethod();
    }
}
