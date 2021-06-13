package com.example.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.Repository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.data.EmployeeData;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeApi {
	
	@Autowired
	EmployeeService employeeService;
	@Autowired
	EmployeeRepository repository;
	
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
	
	@GetMapping("/getemployee")
	public ResponseEntity<EmployeeData> getEmployee(@RequestParam String userId){
		EmployeeData existingEmp=null;
		try {
			existingEmp=employeeService.getEmployeeDetails(userId);					
		}
		catch(Exception e) {
			return null;
		}
		return new ResponseEntity<>(existingEmp, HttpStatus.OK);
		
	}
	
	@PostMapping("/update")
	@ResponseBody
	public ResponseEntity<EmployeeData> updateEmployee(@RequestBody EmployeeData profileData){
		EmployeeData updatedEmployee=null;
		try {
			updatedEmployee=employeeService.updateEmployee(profileData);
			
		}
		catch(Exception e) {
			updatedEmployee=null;
		}
		
		return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
		
	}
	
	@GetMapping("delete/{userId}")
	@ResponseBody
	public String deleteEmployee(@PathVariable String userId) {
		try {
			repository.deleteByUserId(userId);
		}
		catch(Exception e){
			return("error occued wile");
		}
		return("Employee deleted successfully");
	}
	
	
	
	
	

}
