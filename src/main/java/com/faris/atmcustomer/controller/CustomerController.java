package com.faris.atmcustomer.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.faris.atmcustomer.entity.Customer;
import com.faris.atmcustomer.service.CustomerService;


@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {
	
	private CustomerService customerService;
	
	public CustomerController(CustomerService custService)
	{
		customerService = custService;
	}
	
	@GetMapping("/deposit/{id}")
	public ResponseEntity<Customer> getCustomerByIdDepo(@PathVariable("id") int id) {
		Customer custData = null;

		try {
			custData = customerService.findById(id);
			custData.setSaldo(0d);
			
			return new ResponseEntity<>(custData, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/withdraw/{id}")
	public ResponseEntity<Customer> getCustomerByIdWithdraw(@PathVariable("id") int id) {
		Customer custData = null;

		try {
			custData = customerService.findById(id);
			custData.setSaldo(0d);
			
			return new ResponseEntity<>(custData, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/search/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable("id") int id) {
		Customer custData = null;
		try {
			custData = customerService.findById(id);
			
			return new ResponseEntity<>(custData, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/update/{id}")
	public ResponseEntity<String> updateCustomer(@PathVariable("id") int id, @RequestBody Customer customer) {
		Customer custData = null;

		try {
			custData = customerService.findById(id);
			
			Customer _customer = custData;
			_customer.setSaldo(_customer.getSaldo().doubleValue() + customer.getSaldo().doubleValue());
			_customer.setHistoryDt(LocalDateTime.now());
			customerService.save(_customer);
			
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/updateWithdraw/{id}")
	public ResponseEntity<String> updateWithdrawCustomer(@PathVariable("id") int id, @RequestBody Customer customer) {
		Customer custData = null;

		try {
			custData = customerService.findById(id);
			
			Customer _customer = custData;
			if(_customer.getSaldo().doubleValue() >= customer.getSaldo().doubleValue())
			{
				_customer.setSaldo(_customer.getSaldo().doubleValue() - customer.getSaldo().doubleValue());
				_customer.setHistoryDt(LocalDateTime.now());
				customerService.save(_customer);
				
				return new ResponseEntity<>(HttpStatus.OK);
			}
			else {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
}
