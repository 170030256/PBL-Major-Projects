package com.wipro.eb.exception;

public class InvalidReadingException extends Exception {
	private static String str;
	public String toString() {
		return "Incorrect Reading";
	}
	public InvalidReadingException()
	{
	  super(str);
	}

}
