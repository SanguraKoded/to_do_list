package com.sangura.to_do_list.to_do_list.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sangura.to_do_list.to_do_list.entities.Tasks;
import com.sangura.to_do_list.to_do_list.entities.User;
import com.sangura.to_do_list.to_do_list.exceptions.InvalidEmailException;
import com.sangura.to_do_list.to_do_list.exceptions.InvalidUniqueUser;
import com.sangura.to_do_list.to_do_list.repo.UserRepo;

@Service
public class UserService {

	@Autowired
	UserRepo userRepo;
	
	public User createUser(User user) {
		String email = user.getEmail();
		if (!email.endsWith("@gmail.com")) {
			throw new InvalidEmailException("Must contain '@gmail.com'");
			
		}
		
		return userRepo.save(user);
	}
	
	public User updateUserById(int id, User user) {
		userRepo.findById(id).orElseThrow(() -> new RuntimeException("Given Id is incorrect"));
		if (userRepo.existsByUserName(user.getUserName())) {
			throw new InvalidUniqueUser ("Username already exists");
		}
		if (!user.getEmail().endsWith("@gmail.com")) {
			throw new InvalidEmailException ("Must Contain '@gmail.com'");
		}
		
		return userRepo.save(user);
	}
	
	
	public List<User> getAllUsers(){
		return userRepo.findAll();
	}
	
	public User findUserById(int id) {
		
		return userRepo.findById(id).orElseThrow(() -> new RuntimeException("Given Id is incorrect"));
		
	}
	
	public String deleteUserById(int id) {
		userRepo.findById(id).orElseThrow(() -> new RuntimeException("Given Id is incorrect"));
		userRepo.deleteById(id);
		return ("User:" +id +"is deleted");
	}
	
	public List<Tasks> getTasksByUserId(int id){
		
		User user =  userRepo.findById(id).orElseThrow(() -> new RuntimeException("Given User ID is incorrect"));
		return user.getTasks();
		
		
	}
	
}
