package com.wipro.eb.exception;

public class InvalidConnectionException extends Exception{
	private static String str;
	public String toString() {
		return "Incorrect Reading";
	}
	public InvalidConnectionException()
	{
	  super(str);
	}
}
