package dev.khalil.entities;

public class User {

	private String name;
	private String userName;
	private String password;
	private int userID;
	private double balance;
	private long accountNumber;
	

	public User() {
		super();
	} 
	
	public User(String name, String userName, String password) {
		this.name = name;
		this.userName = userName;
		this.password = password;
		this.balance = 0;
	}
	
	
	
	public User(String userName, String password) {
		this.userName = userName;
		this.balance = 0;
		this.password = password;
	}	
	
//Generated Getters And Setters
	
	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public int getUserID() {
		return userID;
	}



	public void setUserID(int userID) {
		this.userID = userID;
	}
	
// Override toString Method

	@Override
	public String toString() {
		return "[Name=" + name + ", UserName=" + userName + ", User ID=" + userID + "]";
	}



	
	
}
