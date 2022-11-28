package com.example.ExceptionHandling.controller;

import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ExceptionHandling.dto.UserRequest;
import com.example.ExceptionHandling.entity.User;
import com.example.ExceptionHandling.service.UserService;
import com.example.ExceptionHandling.service.UsernotFoundException;
//MethodArgumentNotValidException
@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService service;
	@PostMapping("/signup")
	public User saveuser(@RequestBody @Valid UserRequest userrequest){
		return service.saveUser(userrequest);
	}
	@GetMapping("/fetchAll")
	public List<User> getAllUsers(){
		return service.getAllUsers();
	}
	@CachePut(cacheNames = "user", key="#id")
	@GetMapping("/{id}")
	public User getUser(@PathVariable int id) throws UsernotFoundException{
		User u=service.getUser(id);
		System.out.println("get user called");
		return u;
	}
	@GetMapping("/getbyname/{name}")
	public User userbyname(@PathVariable String name){
		return service.userbyname(name);
	}
	@CacheEvict(cacheNames = "user",key="#id")
	@DeleteMapping("/{id}")
	public User deleteUser(@PathVariable int id) throws UsernotFoundException {
		return service.deleteUser(id);
	}
}