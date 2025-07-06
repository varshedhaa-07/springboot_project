package com.example.firstspringproject.controllers;

import com.example.firstspringproject.models.Employee;
import com.example.firstspringproject.services.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class HelloWorldController {
    @Autowired
    private HelloWorldService hws;
    @GetMapping
    public List<Employee> getMethod(){
        return hws.getMethod();
    }

    @GetMapping("/{EmpId}")
    public Employee getEmployeeById(@PathVariable int EmpId){
        return hws.getEmployeeById(EmpId);
    }

    @PostMapping
    public void postMethod(@RequestBody Employee emp){
        hws.postMethod(emp);
    }

    @PutMapping
    public String putMethod(@RequestBody Employee employee){
        return hws.putMethod(employee);
    }

    @DeleteMapping("/{EmpId}")
    public String deleteMethod(@PathVariable int EmpId){
        return hws.deleteMethod(EmpId);
    }
}
