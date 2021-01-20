package dev.khalil.services;

import java.util.List;

import dev.khalil.daos.AdminDAOS;
import dev.khalil.entities.Admin;

public class AdminServicesImpl  {
	
	 static AdminDAOS adaos = new AdminDAOS();
    
	public boolean signUp(String name, String userName, String password) {
		Admin admin = new Admin(name, userName, password);
		return adaos.signUp(admin);
		
	}
	
	
	public Admin signIn(String userName, String password) {
		
		Admin admin = new Admin(userName, password);
		return adaos.signIn(admin);
		
		
	}
	
	
	
	public static List<String> getAllAdmin(){
		
		return adaos.getAllAdmins();
	
	} 
	
	
	

}
