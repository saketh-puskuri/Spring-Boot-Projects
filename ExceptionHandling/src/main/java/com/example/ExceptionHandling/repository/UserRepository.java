package com.example.ExceptionHandling.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ExceptionHandling.entity.User;

public interface UserRepository extends JpaRepository<User,Integer>{

	User findByUserId(int id);

	User findByName(String name);
}
