package com.example.Task2.Controller;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Task2.Entity.UserEntity;
import com.example.Task2.Services.MyServices;
@RestController
public class MyController {
	@Autowired
	private MyServices service;
	@PostMapping("/addUser")
	public UserEntity addUser(@RequestBody UserEntity user) {
		System.out.println(user.getName()+" "+user.getId());
		return service.save(user);
	}
	@GetMapping("/{id}")
	public UserEntity findUser(@PathVariable int id) {
		return service.userById(id);
	}
	@GetMapping("/getChildrenTree/{id}")
	public List<Object> getChildrenTreeById(@PathVariable int id){
		return service.getChildrenTreeById(id);
	}
	@GetMapping("/getChildrenTree")
	public List<Object> getChildrenTree(){
		return service.getChildrenTree(0);
	}
}
