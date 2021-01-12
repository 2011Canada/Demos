package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.exceptions.CustomerNotFoundException;
import com.revature.models.Customer;
import com.revature.repositories.CustomerDao;

@Service
public class CustomerServiceImpl implements CustomerService{

	CustomerDao cd;
	
	@Autowired
	public CustomerServiceImpl(CustomerDao cd) {
		this.cd = cd;
	}
	
	@Override
	public List<Customer> findAllCustomers() {
		// TODO Auto-generated method stub
		return cd.findAll();
	}

	@Override
	public Customer findCustomerById(int id) {
		// TODO Auto-generated method stub
		return cd.getOne(id);
	}

	@Override
	public Customer saveCustomer(Customer C) {
		// TODO Auto-generated method stub
		return cd.saveAndFlush(C);
	}

	@Override
	public Customer findByName(String name) {
		// TODO Auto-generated method stub
		Customer c = cd.findCustomerByName(name);
		if(c == null) {
			throw new CustomerNotFoundException();
		}
		return c;
	}

}
