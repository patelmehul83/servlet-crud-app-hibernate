package com.domain.service;

import java.util.List;

import com.domain.Employee;

public interface EmployeeService {

	 void create(Employee employee);

     List<Employee> getAll();
     
     void delete(int employeeId);
     
     Employee findById(int id);
     

}