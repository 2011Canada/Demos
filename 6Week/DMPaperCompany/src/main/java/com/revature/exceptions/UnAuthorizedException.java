package com.revature.exceptions;

import org.springframework.http.HttpStatus;

public class UnAuthorizedException extends AbstractHttpException {

	public UnAuthorizedException() {
		super("You Do Not have Permissions to Access This Endpoint", HttpStatus.FORBIDDEN);
		// TODO Auto-generated constructor stub
	}

}
