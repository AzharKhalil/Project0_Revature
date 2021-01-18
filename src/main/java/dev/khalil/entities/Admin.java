package dev.khalil.entities;

public class Admin {

	private int adminId; 
	private String name;
	private String userName;
	private String password;
	
	
	public Admin(String name, String userName, String password) {
		super();
		this.name = name;
		this.userName = userName;
		this.password = password; 
		this.adminId = 0;
	}


	


	public Admin(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}





	public int getAdminId() {
		return adminId;
	}


	public void setAdminId(int adminId) {
		this.adminId = adminId;
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


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "Admin [name=" + name + ", userName=" + userName + ", password=" + password + "]";
	}
	
	
	
	
}
