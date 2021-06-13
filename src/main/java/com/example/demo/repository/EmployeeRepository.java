package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, String> {
	
	public Optional<Employee> findByUserId(String userId);
	public void deleteByUserId( String userId);

}
