package com.example.firstspringproject.services;

import com.example.firstspringproject.jwt.JwtTokenProvider;
import com.example.firstspringproject.models.RegisterDetails;
import com.example.firstspringproject.models.Roles;
import com.example.firstspringproject.models.UserDetailsDto;
import com.example.firstspringproject.repository.RegisterDetailsRepository;
import com.example.firstspringproject.repository.RegisterRepository;
import com.example.firstspringproject.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AuthService {

    @Autowired
    RegisterRepository registerRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    RegisterDetailsRepository registerDetailsRepository;

    @Autowired
    RolesRepository rolesRepository;

    @Autowired
    PasswordEncoder passwordEncoder;


    public String addNewEmployee(UserDetailsDto register) {
        RegisterDetails registerDetails=new RegisterDetails();
        registerDetails.setEmpId(register.getEmpId());
        registerDetails.setName(register.getName());
        registerDetails.setEmail(register.getEmail());
        registerDetails.setPassword(passwordEncoder.encode(register.getPassword()));
        registerDetails.setUserName(register.getUserName());
        Set<Roles> roles = new HashSet<>();
        for(String roleName : register.getRoleNames()){
            Roles role=rolesRepository.findByRoleName(roleName)
                            .orElseThrow(()->new RuntimeException("Role not found" + roleName));
            roles.add(role);
        }
        registerDetails.setRoles(roles);
        System.out.println("Registration" + registerDetails);
        registerDetailsRepository.save(registerDetails);
        return "Employee Registered Successfully";
    }

//    public String authenticate(RegisterDetails login) {
//        RegisterDetails user=registerDetailsRepository.findByEmail(login.getEmail());
//        if(user!=null){
//            if(passwordEncoder.matches(login.getPassword(),user.getPassword())){
//                return "Login Successful";
//            }
//        }
//            return "Login not successful";
//    }

    public String authenticate(RegisterDetails login){
        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                login.getUserName(),login.getPassword()));
        return  jwtTokenProvider.generateToken(authentication);
    }

    public Optional<RegisterDetails> getUserByUsername(String username){
        return registerRepository.findByUserName(username);
    }
}