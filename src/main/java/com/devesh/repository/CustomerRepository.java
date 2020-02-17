package com.devesh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devesh.entity.Customer;

/**
 * 
 * @author devesh
 *
 */
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
