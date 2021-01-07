package com.revature;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.services.CatalogueService;
import com.revature.services.UserService;

public class SpringLauncher {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		
		UserService us = ac.getBean(UserService.class);
		System.out.println(us.getUser(1));
		System.out.println(us.getUserPurchaseHistory(1));
		CatalogueService cs = (CatalogueService) ac.getBean("Catalogue Service");
		
		System.out.println(cs.getCatalogueById(1));
		System.out.println(cs.getMediaFromCatalogue(1));
		
		
		((AbstractApplicationContext)ac).close();
	}
}
