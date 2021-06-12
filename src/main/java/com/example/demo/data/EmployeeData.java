package com.example.demo.data;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"id","userId","firstName","lastName","mobile","password"})
public class EmployeeData implements Serializable {
	public EmployeeData() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonProperty("firstName")
	private String firstName;
	@JsonProperty("userId")
	private String userId;
	
	@JsonProperty("lastName")
	private String lastName;
	@JsonProperty("mobile")
	private String mobile;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	@JsonProperty("lastName")
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@JsonProperty("mobile")
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	@JsonProperty("userId")
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	@Override
	public String toString() {
		return "EmployeeData [firstName=" + firstName + ", userId=" + userId + ", lastName=" + lastName + ", mobile="
				+ mobile + "]";
	}
	
	public EmployeeData(String firstName, String userId, String lastName, String mobile, String password) {
		super();
		this.firstName = firstName;
		this.userId = userId;
		this.lastName = lastName;
		this.mobile = mobile;
		
	}
	
	
	
	
	

}
