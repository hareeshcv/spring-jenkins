package com.example.demoapp.dao;

import com.example.demoapp.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    public List<Employee> findAll();

    public Employee findById(int theId);
    public void save(Employee theEmployee);
    public void deleteById(int theId);
}
