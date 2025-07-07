package com.example.firstspringproject.services;

import com.example.firstspringproject.models.Employee;
import com.example.firstspringproject.repository.EmplyeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class HelloWorldService {

    @Autowired
    EmplyeeRepository empRepo;

    public List<Employee> getMethod() {
        return empRepo.findAll();
    }

    public Employee getEmployeeById(int empId) {
        return empRepo.findById(empId).orElse(new Employee());
    }

    public String addEmployee(Employee emp) {
        empRepo.save(emp);
        return "Employee added successfully";
    }

    public String updateEmployee(Employee employee) {
        empRepo.save(employee);
        return "Employee updated successfully";
    }

    public String deleteEmployee(int empId) {
        empRepo.deleteById(empId);
        return "Employee deleted successfully";
    }
}
