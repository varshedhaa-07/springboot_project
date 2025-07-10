package com.example.firstspringproject.controllers;

import com.example.firstspringproject.models.RegisterDetails;
import com.example.firstspringproject.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthService  authService;

    @GetMapping
    public List<RegisterDetails> getRegisteredUsers(){
        return authService.getRegisteredUsers();
    }

    @PostMapping("/register")
    public String addNewUser(@RequestBody RegisterDetails register){
       return authService.addNewEmployee(register);
    }

    @GetMapping("/login")
    public String Login(@RequestBody RegisterDetails login){
        return authService.authenticate(login);
    }
}
