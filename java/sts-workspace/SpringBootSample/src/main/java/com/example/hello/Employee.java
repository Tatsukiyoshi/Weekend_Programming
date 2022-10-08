package com.example.hello;

import lombok.Data;

@Data
public class Employee {
	private String employeeId;
	private String employeeName;
	private int employeeAge;

	public String getEmployeeId() {
		return employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public int getEmployeeAge() {
		return employeeAge;
	}
	
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public void setEmployeeName(String name) {
		this.employeeName = name;
	}
	
	public void setEmployeeAge(int age) {
		this.employeeAge = age;
	}
}
