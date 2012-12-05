package com.project7.models;

import com.project7.abstracts.Employee;

public class HourlyWorker extends Employee{
	private double hourlyRate;
	private int hoursWorked;
	private int payCode;
	private int employeeID;
	
	public HourlyWorker( int payCode, double hourlyRate, int hoursWorked, int employeeID) {
		setHourlyRate(hourlyRate);
		setHoursWorked(hoursWorked);
		setNumber(payCode);
		setEmployeeID(employeeID);
	}
	
	public double getHourlyRate() {
		return hourlyRate;
	}

	public void setHourlyRate(double hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

	public int getHoursWorked() {
		return hoursWorked;
	}

	public void setHoursWorked(int hoursWorked) {
		this.hoursWorked = hoursWorked;
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
