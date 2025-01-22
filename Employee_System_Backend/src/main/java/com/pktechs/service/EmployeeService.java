package com.pktechs.service;

import java.util.List;

import com.pktechs.model.Employee;

public interface EmployeeService {
	
	public Employee createEmployee(Employee employee);
	
	public List<Employee> getAllEmployees();
	
	public Employee getEmployeeById(int id);
	
	public void deleteEmployee(int id);
	
	public Employee updateEmployee(int id, Employee emp);

}
