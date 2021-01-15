package com.revature.remote;

import org.springframework.stereotype.Component;

import com.revature.models.User;

@Component
public class UserServiceFallback implements FeignUserService{

	@Override
	public User getAllUser() {
		// TODO Auto-generated method stub
		System.out.println("User Service Down");
		return null;//sorry couldn't get the data
	}

}
