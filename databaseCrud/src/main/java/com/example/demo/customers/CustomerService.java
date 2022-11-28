package com.example.demo.customers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepo repo;
	
	List<Customers> customers=new ArrayList<>(Arrays.asList(new Customers(1,"Saketh","Java"),
			new Customers(2,"Abcd","Python"),
			new Customers(3,"efgh","Ruby")));
	
	public List<Customers> getAll(){
		List<Customers> result=new ArrayList<>();
		repo.findAll().forEach(result::add);
		return result;
	}
	public Optional<Customers> getCustomer(int id) {
//		for(Customers c:customers) {
//			if(c.getCid()==id) {
//				return c;
//			}
//		}
//		return new Customers(id);
		return repo.findById(id);
	}
	public void addCustomer(Customers customer) {
		repo.save(customer);
	}
	public void updateCustomer(int id,Customers customer) {
		repo.save(customer);
	}
	public void deleteCustomer(int id) {
		repo.deleteById(id);
	}

	
}
