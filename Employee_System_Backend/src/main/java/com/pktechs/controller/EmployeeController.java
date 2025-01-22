package com.pktechs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pktechs.model.Employee;
import com.pktechs.service.EmployeeService;


@CrossOrigin(origins = "http://localhost:3000/")
@Controller
@RequestMapping("/api/v1")
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	
	@PostMapping("/save")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee emp){
		return new ResponseEntity<Employee>(empService.createEmployee(emp), HttpStatus.CREATED
				);
	}
	
	
	@GetMapping("/")
	public ResponseEntity<List<Employee>> getAllEmployee(){
		return new ResponseEntity<List<Employee>>(empService.getAllEmployees(),HttpStatus.OK);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable int id){
		
		return  new ResponseEntity<Employee>(empService.getEmployeeById(id), HttpStatus.OK);
	}
	
	
	@GetMapping("/delete/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable int id){
		
		empService.deleteEmployee(id);
		
		return new ResponseEntity<String>("Delete Sucessfully", HttpStatus.OK);
	}
	
	
	@PostMapping("/update/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody Employee emp){
		
		return new ResponseEntity<Employee>(empService.updateEmployee(id, emp), HttpStatus.OK);
		
	}
	
	
	
	
	
	
	

}
