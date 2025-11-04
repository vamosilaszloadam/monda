package com.example;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.example.models.Employee;
import com.example.models.EmployeeSource;
import com.example.models.Sqlite;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        // new Sqlite().connect();
        // ArrayList<Employee> empList = new EmployeeSource(new Sqlite()).index();
        
        EmployeeSource es = new EmployeeSource(new Sqlite());

        Employee newemp = new Employee(
            "Csomó Imre", 
            "Hatvan", 
            new BigDecimal(397.2)
        );
        // es.store(newemp);

        Employee updateemp = new Employee(
            "Tan Aranka", 
            "Hatvan", 
            new BigDecimal(397.2)
        );
        // es.update(updateemp, 5);

        // es.destroy(5);
        
        ArrayList<Employee> empList = es.index();
        empList.forEach((emp) -> {
            System.out.printf(
                "%d %s %s\n",
                emp.getId(),
                emp.getName(),
                emp.getCity()
                );
        });
    }
}