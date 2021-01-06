package com.revature.repositories;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.proxy.HibernateProxy;

import com.revature.models.Bear;
import com.revature.models.Den;
import com.revature.utils.SessionFactoryUtil;

public class BearHibernateDao implements BearDao {

	SessionFactory sf = SessionFactoryUtil.getSessionFactory();

	public List<Bear> findAll() {
		// always start with getting a session
		Session sess = sf.openSession();
		// you really should start a transaction as well
		Transaction t = sess.beginTransaction();

		// this is where we actually do what we want the method to do
		Query allBears = sess.createQuery("FROM Bear");// string of HQL or SQL
		List<Bear> sb = allBears.list();
		// if you have a transaction remeber to commit once you are successful
		t.commit();
		// when we are done with the session close it
		sess.close();
		return sb;
	}

	public Bear getOne(int id) {
		// always start with getting a session
		Session sess = sf.openSession();
		// you really should start a transaction as well
		Transaction t = sess.beginTransaction();

		// this is where we actually do what we want the method to do
		Bear b = (Bear) sess.get(Bear.class, id);
		// we should check b for null and throw a BearNotFound exception if it is
		// how to manually pop a proxy
		Hibernate.initialize(b.getHome());
		Den d = (Den) ((HibernateProxy) b.getHome()).getHibernateLazyInitializer().getImplementation();
		b.setHome(d);
		// if you have a transaction remeber to commit once you are successful
		t.commit();
		// when we are done with the session close it
		sess.close();
		return b;
	}

	public Bear updateBear(Bear b) {
		// always start with getting a session
		Session sess = sf.openSession();
		// you really should start a transaction as well
		Transaction t = sess.beginTransaction();

		// this is where we actually do what we want the method to do
		// we will be right back
		sess.update(b);
		// if you have a transaction remeber to commit once you are successful
		
		t.commit();
		// when we are done with the session close it
		sess.close();
		return b;
	}

	public Bear buildABear(Bear b) {
		// always start with getting a session
		Session sess = sf.openSession();
		// you really should start a transaction as well
		Transaction t = sess.beginTransaction();

		// this is where we actually do what we want the method to do
		System.out.println(b.getBearId());
		// we will be right back
		sess.save(b);
		System.out.println(b.getBearId());
		// if you have a transaction remember to commit once you are successful
		t.commit();
		// when we are done with the session close it
		sess.close();
		return b;
	}

	public void deleteBear(Bear b) {
		Session sess = sf.openSession();
		// you really should start a transaction as well
		Transaction t = sess.beginTransaction();

		// this is where we actually do what we want the method to do
		sess.delete(b);

		// if you have a transaction remember to commit once you are successful
		t.commit();
		// when we are done with the session close it
		sess.close();
	}

	public List<Bear> findBearByColour(String colour) {
		// always start with getting a session
		Session sess = sf.openSession();
		// you really should start a transaction as well
		Transaction t = sess.beginTransaction();
		// this is where we actually do what we want the method to do
		Query bearsByColour = sess.createQuery("FROM Bear WHERE colour = :c");// string of HQL or SQL
		bearsByColour.setParameter("c", colour);
		
		
		List<Bear> sb = bearsByColour.list();
		// if you have a transaction remeber to commit once you are successful
		t.commit();
		// when we are done with the session close it
		sess.close();
		return sb;

	}
	
	public List<Bear> bearByCriteria() {
		Session sess = sf.openSession();
		// you really should start a transaction as well
		Transaction t = sess.beginTransaction();
		// this is where we actually do what we want the method to do
		Criteria bears = sess.createCriteria(Bear.class);
		//this criteria starts as FROM Bear
		bears.add(Restrictions.ilike("colour", "b%"));
		bears.add(Restrictions.gt("weight", new BigDecimal(1200)));
		List<Bear> sb = bears.list();
		// if you have a transaction remeber to commit once you are successful
		t.commit();
		// when we are done with the session close it
		sess.close();
		return sb;
	}

}
