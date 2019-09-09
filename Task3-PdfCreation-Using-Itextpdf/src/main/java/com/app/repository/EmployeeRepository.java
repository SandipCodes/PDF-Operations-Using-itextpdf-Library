package com.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.app.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}
