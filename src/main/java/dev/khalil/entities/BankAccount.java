package dev.khalil.entities;

public class BankAccount {
	
	private int bankId;
	private double balance;
	private int pin;
	private int userId;
	
	
	
	
	
	
	
	public BankAccount() {
		super();
	}



	public BankAccount(double balance, int pin, int userId) {
		this.balance = balance;
		this.pin = pin;
		this.userId = userId; 
		
	}



	public int getBankId() {
		return bankId;
	}



	public void setBankId(int bankId) {
		this.bankId = bankId;
	}



	public double getBalance() {
		return balance;
	}



	public void setBalance(double balance) {
		this.balance = balance;
	}



	public int getPin() {
		return pin;
	}



	public void setPin(int pin) {
		this.pin = pin;
	}



	public int getUserId() {
		return userId;
	}



	public void setUserId(int userId) {
		this.userId = userId;
	}



	@Override
	public String toString() {
		return "[Account Number=" + bankId + ", balance=" + balance + ", pin=" + pin + "]";
	}
	
	
	
	
	
	
}
