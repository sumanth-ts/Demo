package com.example.demo.mapper;

import com.example.demo.data.EmployeeData;
import com.example.demo.model.Employee;

public interface EmployeeMapper {
	
	Employee convertToProfileData(EmployeeData employee);
	EmployeeData convertToCreateresponse(Employee profile);

}
