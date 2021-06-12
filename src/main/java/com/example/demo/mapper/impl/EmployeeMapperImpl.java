package com.example.demo.mapper.impl;

import org.springframework.stereotype.Component;

import com.example.demo.data.EmployeeData;
import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.model.Employee;

@Component
public class EmployeeMapperImpl implements EmployeeMapper {
	
	@Override
	public Employee convertToProfileData(EmployeeData profile) {
		if(profile==null) {
			return null;
		}
		Employee emp=new Employee();
		
		emp.setUserId(profile.getUserId());
		emp.setFirstName(profile.getFirstName());
		emp.setLastName(profile.getLastName());
		emp.setMobile(profile.getMobile());	
		return emp;
	}

	@Override
	public EmployeeData convertToCreateresponse(Employee profile) {
		if(profile==null) {
			return null;
		}
		EmployeeData emp=new EmployeeData();
		
		emp.setUserId(profile.getUserId());
		emp.setFirstName(profile.getFirstName());
		emp.setLastName(profile.getLastName());
		emp.setMobile(profile.getMobile());	
		return emp;
	}

}
