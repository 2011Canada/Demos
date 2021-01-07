package com.revature.services;

import com.revature.repositories.PurchaseHistoryDao;
import com.revature.repositories.UserDao;

public class UserServiceImpl implements UserService {

	private UserDao ud;
	
	private PurchaseHistoryDao phd;
	
	
	public UserServiceImpl(UserDao ud, PurchaseHistoryDao phd) {
		this.ud = ud;
		this.phd = phd;
	}
	
	
	public String getUser(int id) {
		return ud.getByID(id);
	}

	public String getUserPurchaseHistory(int userId) {
		//pretend to find purchases
		return phd.getByID(userId);
	}

}
