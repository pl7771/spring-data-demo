package com.ilya.springboot.cruddemo.dao;

import java.util.List;

import com.ilya.springboot.cruddemo.entity.Employee;

public interface EmployeeDAO {
	
	public List<Employee> findAll();
	
	public Employee findEmployee(int id);
	
	public void save(Employee employee);
	
	public void deleteById(int id);
}
