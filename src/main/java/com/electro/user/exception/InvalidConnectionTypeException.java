package com.electro.user.exception;

public class InvalidConnectionTypeException extends RuntimeException{

	private String message;

	public InvalidConnectionTypeException(String message) {
		super(message);
		this.message = message;
	}

	public InvalidConnectionTypeException() {
		super();
	}
	
}
