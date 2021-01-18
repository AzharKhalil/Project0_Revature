package dev.khalil.exceptions;

public class UNAPValidaor {

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
	
	

}
