package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/myapp")
public class CustomerController {
	List<Customers> customers=new ArrayList<>(Arrays.asList(new Customers(1,"Saketh","Java"),
			new Customers(2,"Abcd","Python"),
			new Customers(3,"efgh","Ruby")));
	@GetMapping("/customers")
	public List<Customers> getAll(){
		return customers;
	}
	@GetMapping("/customers/{id}")
	public Customers getCustomer(@PathVariable int id) {
		for(Customers c:customers) {
			if(c.getCid()==id) {
				return c;
			}
		}
		return new Customers(id);
	}
	@PostMapping("customers")
	public String addCustomer(@RequestBody Customers customer) {
		customers.add(customer);
		return "Added successfully";
	}
	@PutMapping("/customers/{id}")
	public void updateCustomer(@PathVariable int id,@RequestBody Customers customer) {
		for(int i=0;i<customers.size();i++) {
			if(customers.get(i).getCid()==id) {
				customers.set(i, customer);
			}
		}
	}
	@DeleteMapping("/customers/{id}")
	public void deleteCustomer(@PathVariable int id) {
		customers.removeIf(c -> c.getCid()==id);
	}
	
	
	
}









