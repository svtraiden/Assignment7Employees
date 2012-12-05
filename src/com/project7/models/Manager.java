package com.project7.models;

import com.project7.abstracts.Employee;

public class Manager extends Employee {

	private double salary;
	private int payCode;
	private int employeeID;

	public Manager(){
		
	}
	
	public Manager(int payCode, double salary, int employeeID) {
		setSalary(salary);
		setNumber(payCode);
		setEmployeeID(employeeID);
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getNumber() {
		return payCode;
	}

	public void setNumber(int number) {
		this.payCode = number;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		super.setEmployeeID(employeeID);
	}

}
