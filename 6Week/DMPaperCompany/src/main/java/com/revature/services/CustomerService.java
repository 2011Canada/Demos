package com.revature.services;

import java.util.List;

import com.revature.models.Customer;

public interface CustomerService {

	public List<Customer> findAllCustomers();
	
	public Customer findCustomerById(int id);
	
	public Customer saveCustomer(Customer C);
	
	public Customer findByName(String name);
		
}
