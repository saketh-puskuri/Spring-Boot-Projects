package com.example.Mapping.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Mapping.Entity.Laptop;
import com.example.Mapping.Entity.Standard;
import com.example.Mapping.Entity.Student;
import com.example.Mapping.Repositories.LaptopRepo;
import com.example.Mapping.Repositories.StandardRepo;
import com.example.Mapping.Repositories.StudentRepo;
@Service
public class MyService {
	@Autowired
	private StudentRepo studentRepo;
	@Autowired
	private LaptopRepo laptopRepo;
	@Autowired
	private StandardRepo standardRepo;
	
	public Laptop addLaptop(Laptop laptop) {
		return laptopRepo.save(laptop);
	}
	public Student addStudent(Student student,int classid,int laptopid) {
		Standard s=standardRepo.findById(classid).orElse(null);
		Laptop l=laptopRepo.findById(laptopid).orElse(null);
		student.setLaptop(l);
		student.setStandard(s);
		return studentRepo.save(student);
	}
	public Standard addStandard(Standard standard) {
		return standardRepo.save(standard);
	}
	public List<Student> getStudentsByClass(int id){
		return studentRepo.findAllByStandardClassid(id);
	}
}
