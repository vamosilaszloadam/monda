package com.example.models;

import java.util.ArrayList;

public interface EmployeeAccessible {
    public ArrayList<Employee> index();
    public void store(Employee emp);
    public void update(Employee emp, int id);
    public void destroy(int id);
}
