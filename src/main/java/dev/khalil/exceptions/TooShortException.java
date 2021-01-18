package dev.khalil.exceptions;

public class TooShortException extends Exception  {

	public int length;
	public TooShortException(int length) {
		super("Cannot be less than 8 Characters");
		this.length = length;
	}

	
}
