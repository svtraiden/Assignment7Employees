package com.project7.models;

import com.project7.abstracts.Employee;

public class CommissionWorker extends Employee {
	private double weeklySales;
	private int payCode;
	private int employeeID;

	public CommissionWorker(int payCode, double weeklySales,  int employeeID) {
		setWeeklySales(weeklySales);
		setNumber(payCode);
		setEmployeeID(employeeID);
	}

	public double getWeeklySales() {
		return weeklySales;
	}

	public void setWeeklySales(double weeklySales) {
		this.weeklySales = weeklySales;
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
