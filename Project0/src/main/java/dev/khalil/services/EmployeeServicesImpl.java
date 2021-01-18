package dev.khalil.services;

import java.util.List;

import dev.khalil.daos.EmployeeDAOS;
import dev.khalil.daos.EmployeeDAOSInterface;
import dev.khalil.entities.Admin;
import dev.khalil.entities.User;

public class EmployeeServicesImpl implements EmployeeServices {

	EmployeeDAOSInterface edao = new EmployeeDAOS();

	public boolean signUp(String name, String userName, String password) {
		User user = new User(name, userName, password);
		return edao.signUp(user);

	}

	public User signIn(String userName, String password) {

		User user = new User(userName, password);
		return edao.signIn(user);

	}
	
	
	public List<User> getAllUsers(){
		
		return edao.getAllUsers();
	
	}

	@Override
	public boolean deleteUser(String userName) {
		edao.deleteUser(userName);
		return false;
	}

}
