//package com.example.firstspringproject.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//public class SpringConfiguration {
//    @Bean
//    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.
//                csrf((csrf)->csrf.disable())
//                        .authorizeHttpRequests(auth->auth.anyRequest().authenticated())
//                                .httpBasic(Customizer.withDefaults());
//        return http.build();
//    }
//
//    @Bean
//    InMemoryUserDetailsManager userDetails() {
//        UserDetails admin = User.builder()
//                .username("admin")
////                .password(passwordEncoder().encode("admin"))
//                .roles("ADMIN")
//                .build();
//        UserDetails ram =User.builder()
//                .username("ram")
////                .password(passwordEncoder().encode("123"))
//                .roles("USER")
//                .build();
//
//
//        return new InMemoryUserDetailsManager(admin,ram);
//    }
//}
