package com.app.service;

import java.util.List;

import com.app.model.Employee;

public interface EmployeeService {

	public void save(Employee e);
	public void update(Employee e);
	public void delete(Integer id);
	public Employee getEmployeeById(Integer id);
	
	public List<Employee> getAllEmployees();
	
	public void mergePdfs();
}//interface
