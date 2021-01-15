package com.revature.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.revature.models.User;

@FeignClient(name = "alec-service", fallback = UserServiceFallback.class)
public interface FeignUserService {

	@GetMapping("/users")
	public User getAllUser();
}
