package com.employee.springboot.crudDemo.service;

import java.util.List;

import com.employee.springboot.crudDemo.entity.Employee;

public interface EmployeeService {


	public List<Employee> findAll();
	
	public Employee findById(int theId);
	
	public void save(Employee theEmployee);
	
	public void deleteById(int theId);
}
