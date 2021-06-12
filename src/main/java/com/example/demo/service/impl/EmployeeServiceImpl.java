package com.example.demo.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.data.EmployeeData;
import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository repository;
	@Autowired
	private EmployeeMapper mapper;
	
	@Override
	public EmployeeData getEmployeeDetails(String userId) {
		Optional<Employee> profile=repository.findByUserId(userId);
		if(profile.isPresent()) {
			return mapper.convertToCreateresponse(profile.get());
		}
		return null;
	}

	@Override
	public EmployeeData createEmployee(EmployeeData profileData) {
		// TODO Auto-generated method stub
		Employee profile;
		try {
			profile=mapper.convertToProfileData(profileData);
			repository.save(profile);
			return mapper.convertToCreateresponse(profile);
		}
		catch(Exception e) {
			return null;
		}
		
	}

	
	

}
