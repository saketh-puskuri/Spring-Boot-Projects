package com.example.Task2.Repository;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Task2.Entity.UserEntity;

public interface MyRepo extends JpaRepository<UserEntity, Integer>{

	ArrayList<UserEntity> findAllByParentid(int id);
}
