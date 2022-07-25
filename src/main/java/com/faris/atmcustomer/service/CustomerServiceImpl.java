package com.faris.atmcustomer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faris.atmcustomer.entity.Customer;
import com.faris.atmcustomer.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	private CustomerRepository customerRepository;
	
	@Autowired
	public CustomerServiceImpl(CustomerRepository custRepository)
	{
		customerRepository = custRepository;
	}
	
	@Override
	public Customer findByNameSingleCustomer(String name) {
		Customer result = customerRepository.findByNameSingleCustomer(name);
		
		Customer cust = null;
		
		if (result != null) {
			cust = result;
		}
		else {
			throw new RuntimeException("Did not find customer name - " + name);
		}
		
		return cust;
	}
	
	@Override
	public Customer findById(int Id) {
		Optional<Customer> result = customerRepository.findById(Id);
		
		Customer theCustomer = null;
		
		if (result.isPresent()) {
			theCustomer = result.get();
		}
		else {
			throw new RuntimeException("Did not find customer id - " + Id);
		}
		
		return theCustomer;
	}
	
	@Override
	public void save(Customer cust) {
		customerRepository.save(cust);
	}
	
}
