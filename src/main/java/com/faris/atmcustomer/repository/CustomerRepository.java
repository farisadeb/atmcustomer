package com.faris.atmcustomer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.faris.atmcustomer.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
	@Query(
		value = "SELECT c FROM tbl_customer c WHERE c.nama = :name ",
        nativeQuery=true)
    public Customer findByNameSingleCustomer(String name);
	
}
