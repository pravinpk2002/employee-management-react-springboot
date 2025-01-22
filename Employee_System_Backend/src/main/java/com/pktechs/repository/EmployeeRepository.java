package com.pktechs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pktechs.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
