package com.exceptionhandling.customexception;

public class StudentNotFoundException extends RuntimeException {
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StudentNotFoundException(String msg ) {
	super(msg);		
	}
}
