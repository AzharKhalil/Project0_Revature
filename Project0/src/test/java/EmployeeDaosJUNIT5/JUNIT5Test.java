package EmployeeDaosJUNIT5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dev.khalil.daos.EmployeeDAOS;
import dev.khalil.entities.User;

class JUNIT5Test {

	
	EmployeeDAOS edaos = new EmployeeDAOS();
	
	User user = new User();
	
	
	@Test
	void signUp() {
		System.out.println(edaos.signUp(user));
	}
	
	
	@Test
	void signIn() {
		
		System.out.println(edaos.signIn(user));
		
	}
	
	@Test
	void deleteUser() {
		
		System.out.println(edaos.deleteUser("Azhar"));
		
	}
	
	@Test 
	void getAllUsers() {
		System.out.println(edaos.getAllUsers());
	}
	
	
	
	
}