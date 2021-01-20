package dev.khalil.daos;

import java.util.List;
import java.util.Set;

import dev.khalil.entities.User;

public interface EmployeeDAOSInterface {
	
	boolean signUp(User user);
	public User signIn(User user); 
	public List<User> getAllUsers();
	public boolean deleteUser(String userName);
	boolean updateuserName(String puserName, String nuserName);
	boolean updatePassword(String userName, String pass);

}
