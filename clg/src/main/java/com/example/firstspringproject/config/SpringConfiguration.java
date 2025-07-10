package com.example.firstspringproject.config;

import com.example.firstspringproject.services.CustomerUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SpringConfiguration {

    @Autowired
    CustomerUserDetailsService customerUserDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf((csrf)->csrf.disable())
                .authorizeHttpRequests(auth-> {
//                            auth.requestMatchers(HttpMethod.POST,"/employee").hasRole("ADMIN");
//                            auth.requestMatchers(HttpMethod.PUT,"/employee").hasRole("ADMIN");
//                            auth.requestMatchers(HttpMethod.DELETE,"/employee").hasRole("ADMIN");
//                            auth.requestMatchers(HttpMethod.GET,"/**").hasAnyRole("ADMIN","USER");
                              auth.requestMatchers("/api/auth/register", "/api/auth/login").permitAll();
                            auth.anyRequest().authenticated();
                        })
                        .httpBasic(Customizer.withDefaults());
        return http.build();
    }

//    @Bean
//    InMemoryUserDetailsManager userDetails() {
//        UserDetails admin = User.builder()
//                .username("admin")
//                .password(passwordEncoder().encode("admin"))
//                .roles("ADMIN")
//                .build();
//        UserDetails ram =User.builder()
//                .username("ram")
//                .password(passwordEncoder().encode("123"))
//                .roles("USER")
//                .build();
//
//        return new InMemoryUserDetailsManager(admin,ram);
//    }
}
