package com.example.firstspringproject.repository;

import com.example.firstspringproject.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmplyeeRepository extends JpaRepository<Employee,Integer> {
}
