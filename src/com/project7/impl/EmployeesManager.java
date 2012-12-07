package com.project7.impl;

import java.util.ArrayList;

import com.project7.abstracts.Employee;
import com.project7.interfaces.EmployeesManagerInterface;
import com.project7.models.CommissionWorker;
import com.project7.models.HourlyWorker;
import com.project7.models.Manager;
import com.project7.models.PieceWorker;

public class EmployeesManager implements EmployeesManagerInterface{
	
	public ArrayList<Employee> employeesList = new ArrayList<Employee>();
	@Override
	public void addEmployee(int paycode, double firstParam, int secondParam, int empNum) {
		// TODO Auto-generated method stub
		switch (paycode) {
		case 1: {
			employeesList.add(new Manager(paycode, firstParam, empNum));
			break;
		}
		case 2:{ 
			employeesList.add(new HourlyWorker(paycode, firstParam, secondParam, empNum));
			break;
		}
		case 3: {
			employeesList.add(new CommissionWorker(paycode, firstParam, empNum));
			break;
		}
		case 4: {
			employeesList.add(new PieceWorker(paycode, firstParam, secondParam, empNum));
			break;
		}
		
		}//end switch
		System.out.println(employeesList.size());
		
		/*if(paycode == 1){
			
			employeesList.add(new Manager(firstParam, number, empNum));
			for(Employee emp: employeesList){
				employeesList = new ArrayList<Employee>();
				Manager man = (Manager)emp;
				//System.out.println(man.getNumber());
			}
		} else if(paycode == 2){
			employeesList.add(new HourlyWorker(firstParam, secondParam, 1, empNum));
			for(Employee emp: employeesList){
				employeesList = new ArrayList<Employee>();
				HourlyWorker hw = (HourlyWorker)emp;
				//System.out.println(hw.getNumber());
			}
		} else if(paycode == 3){
			//employeesList.add(new CommissionWorker(firstParam, 1, empNum));
		} else {
			//employeesList.add(new PieceWorker(firstParam, secondParam, 1, empNum));
		}*/
		
		
	}
	
	
		
	@Override
	public int getNumManager() {
		return 0;
	}

	@Override
	public int getNumHourlyWorker() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getNumCommissionWorker() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getNumPieceWorker() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String generateWeeklyReport() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double calculateTotalWeeklyPay() {
		// TODO Auto-generated method stub
		return 0;
	}

}
