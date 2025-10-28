package com.example.models;

import java.math.BigDecimal;

public class Employee {
    private int id;
    private String name;
    private String city;
    private BigDecimal salary;
    
    public Employee() {}
    public Employee(String name, String city, BigDecimal salary) {
        this.name = name;
        this.city = city;
        this.salary = salary;
    }
    public Employee(int id, String name, String city, BigDecimal salary) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.salary = salary;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public BigDecimal getSalary() {
        return salary;
    }
    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
    
}
