package com.company.Interfaces;

import com.company.Objects.Employee;

import java.util.List;

/**
 * Created by RENT on 2017-07-24.
 */
public interface EmployeesDao {
    List<Employee> get();
    void add(Employee employee);
    void update(Employee employee);
    void delete(Employee employee);
}
