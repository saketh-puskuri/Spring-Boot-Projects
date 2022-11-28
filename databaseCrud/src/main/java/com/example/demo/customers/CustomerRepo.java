package com.example.demo.customers;

import org.springframework.data.repository.CrudRepository;

public interface CustomerRepo extends CrudRepository<Customers,Integer>{
	
}
