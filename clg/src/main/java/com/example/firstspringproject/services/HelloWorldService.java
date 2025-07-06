package com.example.firstspringproject.services;

import com.example.firstspringproject.models.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class HelloWorldService {
    List<Employee> e=new ArrayList<>(Arrays.asList(new Employee(1,"John","Trainer"),new Employee(2,"David","Faculty"))
    );

    public List<Employee> getMethod() {
        return e;
    }

    public Employee getEmployeeById(int em) {
        int ind =0;
        boolean flag=false;
        for(int i=0;i<e.size();i++){
            if(em==e.get(i).getEmpId()) {
                ind = i;
                flag = true;
                break;
            }
        }
        if(flag){
            return e.get(ind);
        }else{
            return new Employee();
        }
    }


    public void postMethod(Employee emp) {
        e.add(emp);
    }

    public String putMethod(Employee employee) {
        int ind =0;
        boolean flag=false;
        for(int i=0;i<e.size();i++){
            if(employee.getEmpId()==e.get(i).getEmpId()) {
                ind = i;
                flag = true;
                break;
            }
        }
        if(flag){
            e.set(ind,employee);
            return "Updated";
        }else{
            return "No data found";
        }
    }

    public String deleteMethod(int emp) {
        boolean flag=false;
        for(int i=0;i<e.size();i++) {
            if (emp == e.get(i).getEmpId()){
                flag=true;
                e.remove(i);
                break;
            }
        }
        if(flag)
        return "Deleted";
        else
            return "Item not found";
    }

}
