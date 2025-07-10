package com.example.firstspringproject.services;

import com.example.firstspringproject.models.RegisterDetails;
import com.example.firstspringproject.repository.RegisterDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    RegisterDetailsRepository registerDetailsRepository;

    public List<RegisterDetails> getMethod() {
        return registerDetailsRepository.findAll();
    }

    public RegisterDetails getEmployeeById(int empId) {
        return registerDetailsRepository.findById(empId).orElse(new RegisterDetails());
    }

    public RegisterDetails getEmployeeByRole(String role) {
        return registerDetailsRepository.findByRole(role).orElse(new RegisterDetails());
    }

    public String addEmployee(RegisterDetails employee) {
        registerDetailsRepository.save(employee);
        return "Employee added successfully";
    }

    public String updateEmployee(int empId, RegisterDetails details) {
        RegisterDetails user=registerDetailsRepository.findById(empId)
                .orElseThrow(()->new RuntimeException("No such user present"));
        user.setName(details.getName());
        user.setEmail(details.getEmail());
        user.setPassword(details.getPassword());
        user.setUserName(details.getUserName());
        registerDetailsRepository.save(user);
        return "Employee updated successfully";
    }

    public String deleteEmployee(int empId) {
        registerDetailsRepository.deleteById(empId);
        return "Employee deleted successfully";
    }
}
