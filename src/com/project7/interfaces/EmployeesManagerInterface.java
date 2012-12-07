package com.project7.interfaces;

/**
 * Interface for the Employees class for CS103, Assignment 7, Fall 2012
 * Contains an ArrayList of objects that inherit from the Abstract class Employee
 * Keeps track of the number of Mangers, Hourly Workers, Commission Workers 
 *      and Piece Workers employees
 * @author Professor Myers
 *
 */
public interface EmployeesManagerInterface {
	/**
	 * Add an employee to the ArrayList.
	 * 
	 * @param paycode
	 *            Type of employee: 1-Manager, 2-Hourly Worker, 3-Commission
	 *            Worker, 4-Piece Worker
	 * @param fname
	 *            First Name
	 * @param lname
	 *            Last Name
	 * @param firstParam
	 *            1-salary, 2-hourly rate, 3-weekly sales, 4-rate per piece
	 * @param secondParam
	 *            1-not needed (0), 2-number of hours, 3-not needed (0),
	 *            4-number of pieces
	 * @param empNum
	 *            employee number
	 */
	public void addEmployee(int paycode, double firstParam, int secondParam,
			int empNum);
	
	/**
	 * Returns the number of Managers in the ArrayList
	 * 
	 * @return number of Managers
	 */
	public int getNumManager();

	/**
	 * Returns the number of Hourly Workers in the ArrayList
	 * 
	 * @return number of Hourly Workers
	 */
	public int getNumHourlyWorker();

	/**
	 * Returns the number of Commission Worker in the ArrayList
	 * 
	 * @return number of Commission Worker
	 */
	public int getNumCommissionWorker();

	/**
	 * Returns the number of Piece Worker in the ArrayList
	 * 
	 * @return number of Piece Worker
	 */
	public int getNumPieceWorker();

	/**
	 * Generates a weekly report of employee weekly pay
	 * 
	 * @return String that contains the Weekly Report
	 */
	public String generateWeeklyReport();

	/**
	 * Calculate the total weekly pay for all employees in the ArrayList
	 * 
	 * @return the total weekly pay for all employees
	 */
	public double calculateTotalWeeklyPay();

	/**
	 * Creates a string representation of the object
	 * 
	 * @return String that represents the objects in the ArrayList
	 */
	public String toString();
}
