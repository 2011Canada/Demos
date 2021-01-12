package com.revature.exceptions;

import org.springframework.http.HttpStatus;

public class CustomerNotFoundException extends AbstractHttpException {

	public CustomerNotFoundException() {
		super("Customer Not Found", HttpStatus.NOT_FOUND);
		// TODO Auto-generated constructor stub
	}

}
