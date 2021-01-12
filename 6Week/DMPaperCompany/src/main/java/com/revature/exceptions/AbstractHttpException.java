package com.revature.exceptions;

import org.springframework.http.HttpStatus;

public class AbstractHttpException extends RuntimeException{
	private HttpStatus statusCode;
	
	protected AbstractHttpException(String message, HttpStatus status) {
		super(message);
		this.statusCode = status;
		
	}

	public HttpStatus getStatusCode() {
		return statusCode;
	}
	
	
}
