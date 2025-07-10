package com.example.firstspringproject.services;

import com.example.firstspringproject.models.RegisterDetails;
import com.example.firstspringproject.repository.RegisterDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class AuthService {

    @Autowired
    RegisterDetailsRepository authRepo;

    @Autowired
    PasswordEncoder passwordEncoder;

    public String addNewEmployee(RegisterDetails register) {
        RegisterDetails registerDetails = new RegisterDetails();
        registerDetails.setEmpId(register.getEmpId());
        registerDetails.setEmail(register.getEmail());
        registerDetails.setGender(register.getGender());
        registerDetails.setRole(register.getRole());
        registerDetails.setPassword(passwordEncoder.encode(register.getPassword()));
        registerDetails.setDOB(register.getDOB());
        registerDetails.setEmpName(register.getEmpName());
        authRepo.save(register);
        return "Employee Registered Successfully";
    }

    public List<RegisterDetails> getRegisteredUsers() {
        return authRepo.findAll();
    }

    public String authenticate(RegisterDetails login) {
        RegisterDetails user = authRepo.findByEmail(login.getEmail());
        if(user!=null){
            if(passwordEncoder.matches(login.getPassword(),user.getPassword())){
                return "Login Successfull";
            }else{
                return "Login Successfull";
            }
        }else{
            return "Login Successfull";
        }
    }
}
