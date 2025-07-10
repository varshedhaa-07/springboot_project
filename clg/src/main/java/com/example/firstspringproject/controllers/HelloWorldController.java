package com.example.firstspringproject.controllers;

import com.example.firstspringproject.models.Employee;
import com.example.firstspringproject.services.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class HelloWorldController {
    @Autowired
    private HelloWorldService hws;

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping
    public List<Employee> getMethod(){
        return hws.getMethod();
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/{EmpId}")
    public Employee getEmployeeById(@PathVariable int EmpId){
        return hws.getEmployeeById(EmpId);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public String postMethod(@RequestBody Employee emp){
        return hws.addEmployee(emp);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping
    public String putMethod(@RequestBody Employee employee){
        return hws.updateEmployee(employee);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{EmpId}")
    public String deleteMethod(@PathVariable int EmpId){
        return hws.deleteEmployee(EmpId);
    }
}
