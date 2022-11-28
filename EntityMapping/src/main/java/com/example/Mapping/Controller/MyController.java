package com.example.Mapping.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Mapping.Entity.Laptop;
import com.example.Mapping.Entity.Standard;
import com.example.Mapping.Entity.Student;
import com.example.Mapping.Service.MyService;

@RestController
public class MyController {
	@Autowired
	private MyService service;
	@PostMapping("/addLaptop")
	public Laptop addLaptop(@RequestBody Laptop laptop) {
		return service.addLaptop(laptop);
	}
	@PostMapping("/{classid}/{laptopid}/addStudent")
	public Student addStudent(@RequestBody Student student,@PathVariable int classid,@PathVariable int laptopid) {
		return service.addStudent(student,classid,laptopid);
	}
	@PostMapping("addStandard")
	public Standard addStandard(@RequestBody Standard standard) {
		return service.addStandard(standard);
	}
	@GetMapping("getStudentsByClass/{id}")
	public List<Student> getStudentsByClass(@PathVariable int id){
		return service.getStudentsByClass(id);
	}
}
