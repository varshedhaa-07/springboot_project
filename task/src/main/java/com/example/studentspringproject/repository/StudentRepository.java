package com.example.studentspringproject.repository;

import com.example.studentspringproject.models.Student;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer>{
}
