package com.example.ExceptionHandling.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ExceptionHandling.dto.UserRequest;
import com.example.ExceptionHandling.entity.User;
import com.example.ExceptionHandling.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository repo;
	public User saveUser(UserRequest userrequest) {
		User user=User.build(0, userrequest.getName(), userrequest.getEmail(),userrequest.getMobile()
				,userrequest.getGender(),userrequest.getAge(),userrequest.getNationality());
		return repo.save(user);
	}
	public List<User> getAllUsers(){
		return repo.findAll();
	}
	public User getUser(int id) throws UsernotFoundException {
		if(!repo.existsById(id)) {
			throw new UsernotFoundException("user not available");
		}
		return repo.findByUserId(id);
	}
	public User userbyname(String name) {
		return repo.findByName(name);
	}
	public User deleteUser(int id) throws UsernotFoundException{
		if(!repo.existsById(id)) {
		throw new UsernotFoundException("user not available");
		}
		@SuppressWarnings("deprecation")
//		if(!repo.existsById(id)) {
//			throw new UsernotFoundException("user not available");
//		}
		User user=repo.getById(id);
		User result=User.build(id, user.getName(),user.getEmail(),user.getMobile(),
				user.getGender(),user.getAge(),user.getNationality());
		repo.deleteById(id);
		return result;
	}
}
