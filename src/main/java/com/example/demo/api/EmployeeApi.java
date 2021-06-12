package com.example.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.data.EmployeeData;
import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeApi {
	
	@Autowired
	EmployeeService employeeService;
	
	
	@PostMapping("/create")
	@ResponseBody
	public ResponseEntity<EmployeeData> createEmployee(@Validated @RequestBody EmployeeData employeeData  ) {
		String userId=employeeData.getUserId();
		try {
			EmployeeData existingEmp=employeeService.getEmployeeDetails(userId);
			if(existingEmp!=null) {
				return new ResponseEntity<>(existingEmp, HttpStatus.OK);
			}
			else {
				EmployeeData emp=employeeService.createEmployee(employeeData);
				return new ResponseEntity<>(emp, HttpStatus.OK);			}
		}
		catch(Exception e) {
//			return("Error While creating Employee...");
			return null;
		}
		
		
	}
	

}
