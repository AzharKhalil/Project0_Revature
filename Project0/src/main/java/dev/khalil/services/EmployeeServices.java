package dev.khalil.services;

import java.util.List;

import dev.khalil.entities.User;

public interface EmployeeServices {
	 
	boolean signUp(String name, String userName, String password);
	User signIn(String userName, String password);
	public List<User> getAllUsers();
	public boolean deleteUser(String userName);
	boolean updateuserName(String puserName, String nuserName);
	boolean updatePassword(String userName, String pass);

}
