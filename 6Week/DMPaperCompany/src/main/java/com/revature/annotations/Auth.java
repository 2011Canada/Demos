package com.revature.annotations;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target({METHOD, })
public @interface Auth {
	
	//contain values for who is allowed to use the annotated method
	public String[] roles();
	
	public int test();
		
}
