package com.example.Mapping.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Mapping.Entity.Student;

public interface StudentRepo extends JpaRepository<Student,Integer> {

	List<Student> findAllByStandardClassid(int id);

}
