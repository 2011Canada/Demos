package com.revature.aspects;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.revature.annotations.Auth;
import com.revature.exceptions.NotLoggedInException;
import com.revature.exceptions.UnAuthorizedException;
import com.revature.models.Customer;

@Component
@Aspect
public class AuthAspect {
	

	
	
	//if they have the appropriate role, we should allow the method to execute normally
	//if they don't have the appropriate role
	@Around("execution(* com.revature.controllers..*(..)) && @annotation(auth)")
	public Object authenticateUser(ProceedingJoinPoint pjp, Auth auth) throws Throwable{
		System.out.println("Is the advice running?");
		Customer c = getCurrentCustomer();
		if(c == null) {
			throw new NotLoggedInException();
		}
		for(String role : auth.roles()) {
			if(c.getRole().equals(role)) {
				return pjp.proceed();//this is how to call the original method
			}
		}
		throw new UnAuthorizedException();
	}
	
	public static Customer getCurrentCustomer() {
		
		HttpServletRequest req = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		
		return (Customer) req.getSession().getAttribute("user");
	}

}
