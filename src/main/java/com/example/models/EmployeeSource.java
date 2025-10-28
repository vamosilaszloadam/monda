package com.example.models;

import java.sql.Statement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class EmployeeSource implements EmployeeAccessible {
    Database database;

    public EmployeeSource(Database database) {
        this.database = database;
    }
    @Override
    public ArrayList<Employee> index() {
        try {
            return tryIndex();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
    public ArrayList<Employee> tryIndex() throws SQLException {
        Connection conn = database.connect();
        Statement stmt = conn.createStatement();
        String sql = "select * from employees";
        ResultSet rs = stmt.executeQuery(sql);
        ArrayList<Employee> empList = new ArrayList<>();
        while(rs.next()) {
            Employee emp = new Employee();
            emp.setId(rs.getInt("id"));
            emp.setName(rs.getString("name"));
            emp.setCity(rs.getString("city"));
            emp.setSalary(rs.getBigDecimal("salary"));
            empList.add(emp);
        }
        database.close(conn);
        // conn.close();
        return empList;
    }

    @Override
    public void store(Employee emp) {
        try {
            tryStore(emp);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    private void tryStore(Employee emp) throws SQLException {
        Connection conn = database.connect();
        String url = """
            insert into employees 
            (name, city, salary)
            values
            (?, ?, ?)
            """;
        PreparedStatement ps = conn.prepareStatement(url);
        ps.setString(1, emp.getName());
        ps.setString(2, emp.getCity());
        ps.setBigDecimal(3, emp.getSalary());
        ps.execute();
    }

    @Override
    public void update(Employee emp, int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void destroy(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'destroy'");
    }
    
}
