package com.revature;



import java.math.BigDecimal;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Bear;
import com.revature.utils.SessionFactoryUtil;

public class HibernateLauncher {

	
	public static void main(String[] args) {
		Session sess = SessionFactoryUtil.getSessionFactory().openSession();
		
		Transaction t = sess.beginTransaction();
		
		Bear b = new Bear(0, "Baloo", "Black", "Black", new BigDecimal(800), 2, "Berries");
		
		sess.save(b);
		
		t.commit();
		
		sess.close();
		//b is now detached
	}
}
