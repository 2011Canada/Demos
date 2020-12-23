package com.revature.exceptions;

public class MediaNotFoundException extends RuntimeException {


	private static int numberOfOccurances =0;
	
	
	public MediaNotFoundException() {
		super("That Media Was Not Found, Please Try Again");
		numberOfOccurances++;
	}
}
