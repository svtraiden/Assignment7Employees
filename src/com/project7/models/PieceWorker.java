package com.project7.models;

import com.project7.abstracts.Employee;

public class PieceWorker extends Employee {
	private double pricePerPiece;
	private int piecesSale;
	private int payCode;
	private int employeeID;

	public PieceWorker(int payCode, double pricePerPiece, int piecesSale, 
			int employeeID) {
		setPricePerPiece(pricePerPiece);
		setPiecesSale(piecesSale);
		setNumber(payCode);
		setEmployeeID(employeeID);
	}

	public double getPricePerPiece() {
		return pricePerPiece;
	}

	public void setPricePerPiece(double pricePerPiece) {
		this.pricePerPiece = pricePerPiece;
	}

	public int getPiecesSale() {
		return piecesSale;
	}

	public void setPiecesSale(int piecesSale) {
		this.piecesSale = piecesSale;
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
