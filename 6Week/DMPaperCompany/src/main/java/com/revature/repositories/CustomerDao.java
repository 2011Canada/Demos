package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Customer;

public interface CustomerDao extends JpaRepository<Customer, Integer> {

	public Customer findCustomerByName(String name);
}
