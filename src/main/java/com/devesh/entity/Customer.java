package com.devesh.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author devesh
 *
 */
@Entity
@Table(name = "CUSTOMER")
public class Customer {

	@Id
	@GeneratedValue
	@Column(name = "CUST_ID")
	private Long customerId;

	@Column(name = "CUSTOMER_NAME")
	private String customerName;

	@Column(name = "CUST_SEX")
	private String customerSex;

	@Column(name = "ADDR1")
	private String customerAdd1;

	@Column(name = "ADDR2")
	private String cusromerAdd2;

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerSex() {
		return customerSex;
	}

	public void setCustomerSex(String customerSex) {
		this.customerSex = customerSex;
	}

	public String getCustomerAdd1() {
		return customerAdd1;
	}

	public void setCustomerAdd1(String customerAdd1) {
		this.customerAdd1 = customerAdd1;
	}

	public String getCusromerAdd2() {
		return cusromerAdd2;
	}

	public void setCusromerAdd2(String cusromerAdd2) {
		this.cusromerAdd2 = cusromerAdd2;
	}

}
