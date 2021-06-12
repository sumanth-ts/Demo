package com.example.demo.service;

import com.example.demo.data.EmployeeData;

public interface EmployeeService {

	EmployeeData getEmployeeDetails(String userId);
	EmployeeData createEmployee(EmployeeData profileData);
	EmployeeData updateEmployee(EmployeeData profileData);
}
