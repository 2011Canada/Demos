package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Customer;
import com.revature.services.CustomerService;

@RestController // this tells spring two things. one this is a controller for spring mvc two,
				// these methods only return data not views
@RequestMapping("/customers") // this is the base path for all requests going to this controller
public class CustomerController {

	private CustomerService cs;

	@Autowired
	public CustomerController(CustomerService cs) {
		this.cs = cs;
	}

	@GetMapping // if we send a get request to the base path, this method will execute
	public ResponseEntity<List<Customer>> findAllCustomers() {

		return new ResponseEntity<List<Customer>>(cs.findAllCustomers(), HttpStatus.OK);
	}

	@GetMapping("/{id}") // curly braces denote it as a path variable -> when can extract the data
	public ResponseEntity<Customer> findCustomerById(@PathVariable int id) {

		return new ResponseEntity<Customer>(cs.findCustomerById(id), HttpStatus.OK);

	}

	@PostMapping
	public ResponseEntity<Customer> saveNewCustomer(@RequestBody Customer c) {
		
		return new ResponseEntity<Customer>(cs.saveCustomer(c), HttpStatus.CREATED);
	}
	
	@GetMapping("/name/{name}")
	public ResponseEntity<Customer> findCustomerByName(@PathVariable String name) {

		return new ResponseEntity<Customer>(cs.findByName(name), HttpStatus.OK);

	}

}
