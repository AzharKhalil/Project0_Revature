package dev.khalil.exceptions;

import java.util.List;

import dev.khalil.entities.Admin;
import dev.khalil.entities.User;
import dev.khalil.services.AdminServicesImpl;
import dev.khalil.services.EmployeeServicesImpl;

public class UNAPValidaor {
	
	AdminServicesImpl aserv = new AdminServicesImpl();
	EmployeeServicesImpl eserv = new EmployeeServicesImpl();
	
	public boolean validUN(String string) throws NotValidCharacter {
		
	

		if (string.contains(" ")) {
			NotValidCharacter nvc = new NotValidCharacter();
			throw nvc;

		}
		
	
		

		return true;
	}
	
	
	
	public boolean validPass(String string) throws TooShortException, NotValidCharacter
	{
		if(string.length() < 8) {
			TooShortException tse = new TooShortException(string.length());
			throw tse;
		}
		
		if(string.contains(" ")) {
			NotValidCharacter nvc = new NotValidCharacter();
			throw nvc;
			
			
		}
		
		
		
		return true;
	}
	
	public boolean validPin(int pin) throws TooShortException {
		
		
		if( Integer.toString(pin).length() != 4 ) {
			
			TooShortException tse = new TooShortException(Integer.toString(pin).length());
			throw tse;
			
		}
		
		
		
		return false;	
	}

	
	
	public boolean validBalance(double balance) throws NotValidCharacter {
		
		if(balance<=0) {
			NotValidCharacter nvc = new NotValidCharacter();
			throw nvc;
		}
		
		
		return true;
	} 
	
	
	public boolean adminUserNameAvailable(String userName) throws UserAlreadyExists {
		
		UserAlreadyExists uas = new UserAlreadyExists();
		List<String> admins = aserv.getAllAdmin();
		for(String admin: admins) {
			if(admin.equals(userName)) {
				throw uas;
				
			}
			
		}
		
		
		
		return true;
	}
	
	
	public boolean userUserNameAailable(String userName) throws UserAlreadyExists{
		
		UserAlreadyExists uas = new UserAlreadyExists();
		List<User> users = eserv.getAllUsers();
		for(User user: users) {
			if((user.getUserName()).equals(userName)) {
				throw uas;
			}
		}
		
		return true;
	} 
	
	
 
}
