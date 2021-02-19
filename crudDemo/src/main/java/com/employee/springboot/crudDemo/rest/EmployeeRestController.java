package com.employee.springboot.crudDemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.springboot.crudDemo.entity.Employee;
import com.employee.springboot.crudDemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	
	private EmployeeService employeeService	;
	
	@Autowired
	public EmployeeRestController(EmployeeService theEmployeeService) {
		employeeService=theEmployeeService;
	}
	
	@GetMapping("/employees")
	public List<Employee> findAll(){
		return employeeService.findAll();
	}
	
	@GetMapping("/employees/{employeeId}")
	public Employee get(@PathVariable int employeeId ) {
		
		Employee theEmployee=employeeService.findById(employeeId);
		if(theEmployee==null) {
			throw new RuntimeException("EmployeeId not Found: " + employeeId);
		}
		return theEmployee;
		
	}
	
	@PostMapping("/employees")
	public Employee save(@RequestBody Employee theEmployee) {
		
		theEmployee.setId(0);
		employeeService.save(theEmployee);
		return theEmployee;
		
	}
	@PutMapping("/employees")
	public Employee update(@RequestBody Employee theEmployee) {
		
		
		employeeService.save(theEmployee);
		return theEmployee;
		
	}
	
	@DeleteMapping("/employees/{employeeId}")
	public String delete(@PathVariable int employeeId) {
		Employee tempEmployee=employeeService.findById(employeeId);
		if(tempEmployee==null) {
			throw new RuntimeException("EmployeId doesn't exist: " + employeeId);
			
		}
		employeeService.deleteById(employeeId);
		return "Deleted EmployeeId : " + employeeId;
	}
	
	
	
	
}
