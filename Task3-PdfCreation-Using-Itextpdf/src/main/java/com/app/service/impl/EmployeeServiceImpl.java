package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.model.Employee;
import com.app.repository.EmployeeRepository;
import com.app.service.EmployeeService;

@Service("empService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository repository;
	
	@Override
	@Transactional
	public void save(Employee e) {

		repository.save(e);
	}

	@Override
	@Transactional
	public void update(Employee e) {
        repository.save(e);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
        repository.deleteById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public Employee getEmployeeById(Integer id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Employee> getAllEmployees() {
		return (List<Employee>) repository.findAll();
	}

}
