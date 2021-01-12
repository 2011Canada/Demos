package com.revature.exceptions;

import org.springframework.http.HttpStatus;

public class NotLoggedInException extends AbstractHttpException {

	public NotLoggedInException() {
		super("Please Login", HttpStatus.FORBIDDEN);
		// TODO Auto-generated constructor stub
	}

}
