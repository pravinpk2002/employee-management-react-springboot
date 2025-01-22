package com.pktechs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pktechs.model.Employee;
import com.pktechs.repository.EmployeeRepository;


@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository empRepo;
	
	@Override
	public Employee createEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return empRepo.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return empRepo.findAll();
	}

	@Override
	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		return empRepo.findById(id).get();
	}

	@Override
	public void deleteEmployee(int id) {
		
		
		Employee emp = empRepo.findById(id).get();
		
		if(emp != null) {
			empRepo.delete(emp);
		}
		
		
	}
	
	@Override
	public Employee updateEmployee(int id, Employee emp) {
		
		Employee oldEmp = empRepo.findById(id).get();
		
		if(oldEmp != null) {
			emp.setId(id);
			
			return empRepo.save(emp);
		}
		
		return null;
	}

	
	
}
