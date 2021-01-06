package com.revature;


import java.math.BigDecimal;
import java.util.List;

import com.revature.models.Bear;
import com.revature.repositories.BearDao;
import com.revature.repositories.BearHibernateDao;


public class HibernateLauncher {

	
	public static void main(String[] args) {
		BearDao bd = new BearHibernateDao();
		
		
		Bear yogi = bd.getOne(1);
		//System.out.println(baloo.getHome().getDenName());
		System.out.println(yogi);
		
		Bear baloo = new Bear(0,"Baloo", "black", "Black", new BigDecimal(1200), 2, "Beatles" , null);
		bd.buildABear(baloo);
		
		List<Bear> byC = bd.findBearByColour("Black");
		for(Bear b : byC) {
			System.out.println(b);
		}
		bd.bearByCriteria().forEach(ele->System.out.println(ele));
	}
}
