package com.revature.exceptionhandlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.revature.exceptions.AbstractHttpException;


@ControllerAdvice//turns this into a bean and turns it into a specific form of aspect advice
//this advice always targets all controllers and specifically run @afterthrowing
public class ControllerExceptionHandlers {

	//anything that matches this class will get caught and handled by this method
	@ExceptionHandler(value = {Throwable.class})
	public ResponseEntity<Object> allUncaughtExceptions(Throwable t){
		t.printStackTrace();
		return new ResponseEntity<Object>("OOPS something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@ExceptionHandler(value = {AbstractHttpException.class})
	public ResponseEntity<Object> handleHttpExceptions(AbstractHttpException ahe){
		//by properly making ahe exceptions we can have them all turn directly into http response
		return new ResponseEntity<Object>(ahe.getMessage(), ahe.getStatusCode());
	}
	
	
	
}
