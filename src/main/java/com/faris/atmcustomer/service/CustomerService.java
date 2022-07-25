package com.faris.atmcustomer.service;

import com.faris.atmcustomer.entity.Customer;

public interface CustomerService {
	
	public Customer findByNameSingleCustomer(String name);
	
	public Customer findById(int id);
	
	public void save(Customer cust);
	
}
