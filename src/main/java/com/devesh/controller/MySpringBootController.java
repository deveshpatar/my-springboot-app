package com.devesh.controller;

import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.devesh.entity.Customer;
import com.devesh.entity.Property;
import com.devesh.entity.UserLogin;
import com.devesh.repository.CustomerRepository;
import com.devesh.service.MySpringBootServiceImpl;
import com.devesh.utils.PropertyCSVProcessor;
import com.devesh.utils.UserLoginUtil;

/**
 * 
 * @author devesh
 *
 */
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class MySpringBootController {
	
	private static final Logger logger = LoggerFactory.getLogger(MySpringBootController.class);

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private PropertyCSVProcessor propertyList;
	
	@Autowired
	private MySpringBootServiceImpl mySpringBootServiceImpl;

	// List of timezone from system
	@GetMapping("/timezone")
	public ResponseEntity<Map<String, String>> getSystemTimezoneList() throws IOException, InterruptedException {
		logger.info("---Retirieve List of timezone from system ---");
		return ResponseEntity.ok(mySpringBootServiceImpl.getSystemTimezoneList());
	}
	
	// List of installed languages from system
		@GetMapping("/languages")
		public ResponseEntity<Map<String, String>> getSystemLanguageList() throws IOException, InterruptedException {
			logger.info("---Retirieve List of languages from system ---");
			return ResponseEntity.ok(mySpringBootServiceImpl.getSystemInstalledLanguageList());
		}
	
	// List Properties
	@GetMapping("/properties")
	public List<Property> retrieveAllProperties() {
		logger.info("---Retirieve List of Properties---");
		return propertyList.getPropertyListFromCSV();
	}
	
	/*
	 * @GetMapping("/properties") public List<Property> retrieveAllProperties() {
	 * return propertyList.getPropertyListFromCSV(); }
	 */

	// List Customers
	@GetMapping("/customers")
	public List<Customer> retrieveAllCustomers() {
		logger.info("---Retirieve List of Customers---");
		return customerRepository.findAll();
	}

	// Get Customer Details base on customer Id
	@GetMapping("/customers/{id}")
	public Customer retrieveCustomer(@PathVariable long id) {
		logger.info("---Retirieve Customer Details based on Id---");
		
		Optional<Customer> customer = customerRepository.findById(id);

		

		return customer.get();
	}

	@PutMapping("/customers/{id}")
	public ResponseEntity<Object> updateCustomer(@RequestBody Customer customer, @PathVariable long id) {
		logger.info("---Update customer based on customer id---");
		Optional<Customer> customerOptional = customerRepository.findById(id);

		if (!customerOptional.isPresent())
			return ResponseEntity.notFound().build();

		customer.setCustomerId(id);

		customerRepository.save(customer);

		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/customers/{id}")
	public void deleteCustomer(@PathVariable long id) {
		logger.info("---Delete customer based on customer id---");
		customerRepository.deleteById(id);
	}

	// Add Customer (By Banker)
	@PostMapping("/customers")
	public ResponseEntity<Object> createCustomer(@RequestBody Customer customer) {
		logger.info("---Add Customer---");
		Customer savedCustomer = customerRepository.save(customer);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedCustomer.getCustomerId()).toUri();

		return ResponseEntity.created(location).build();

	}

	// Login
	@Autowired
	private UserLoginUtil loginUtil;

	@PostMapping("/authenticateUser")
	public boolean authenticateUser(@RequestBody UserLogin userLogin) {
		return loginUtil.authenticate(userLogin);
	}
	
	
}
