package com.example.demo.customers;

//import java.util.ArrayList;
//import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
	@Autowired
	CustomerService customerservice;
	@RequestMapping("/customers")
	public List<Customers> getAll(){
		return customerservice.getAll();
	}
	@RequestMapping("/customers/{id}")
	public Optional<Customers> getCustomer(@PathVariable int id) {
		return customerservice.getCustomer(id);
	}
	@RequestMapping(method=RequestMethod.POST,value="/customers")
	public void addCustomer(@RequestBody Customers customer) {
		customerservice.addCustomer(customer);
	}
	@RequestMapping(method=RequestMethod.PUT,value="/customers/{id}")
	public void updateCustomer(@PathVariable int id,@RequestBody Customers customer) {
		customerservice.updateCustomer(id, customer);
	}
	@RequestMapping(method=RequestMethod.DELETE,value="/customers/{id}")
	public void deleteCustomer(@PathVariable int id) {
		customerservice.deleteCustomer(id);
	}
		
}