package com.devesh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devesh.repository.CustomerRepository;

@Service
public class MySpringBootServiceImpl {
	
	@Autowired
	CustomerRepository customerRepository;

}
