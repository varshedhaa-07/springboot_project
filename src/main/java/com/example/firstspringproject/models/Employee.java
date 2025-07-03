package com.example.firstspringproject.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@AllArgsConstructor
public class Employee {

    private int EmpId;
    private String Name;
    private String Job;

    public Employee(int EmpId, String Name, String Job) {
        this.EmpId=EmpId;
        this.Name=Name;
        this.Job=Job;
    }

    public int getEmpId() {
        return EmpId;
    }

    public void setEmpId(int empId) {
        EmpId = empId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getJob() {
        return Job;
    }

    public void setJob(String job) {
        Job = job;
    }
}
