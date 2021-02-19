package com.employee.springboot.crudDemo.dao;

import java.util.List;

import com.employee.springboot.crudDemo.entity.Employee;

public interface EmployeeDAO {

	public List<Employee> findAll();
	
	public Employee findById(int theId);
	
	public void save(Employee theEmployee);
	
	public void deleteById(int theId);
}
