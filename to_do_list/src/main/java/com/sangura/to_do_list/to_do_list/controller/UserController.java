package com.sangura.to_do_list.to_do_list.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sangura.to_do_list.to_do_list.entities.Tasks;
import com.sangura.to_do_list.to_do_list.entities.User;
import com.sangura.to_do_list.to_do_list.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(user));
		
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<User> updateUserById(@PathVariable int id, @RequestBody User user){
		return ResponseEntity.ok(userService.updateUserById(id, user));
	}
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers(){
		return ResponseEntity.ok(userService.getAllUsers());
	}
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable int id){
		return ResponseEntity.ok(userService.findUserById(id));
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteUserById(@PathVariable int id){
		userService.deleteUserById(id);
		ResponseEntity.noContent().build();
		String message = "User with Id "+id+" is successfully deleted";
		return ResponseEntity.ok(message);
	}
	
	@GetMapping("/tasks/{id}")
	public ResponseEntity<List<Tasks>> tasksByUserId(@PathVariable int id){
		return ResponseEntity.ok(userService.getTasksByUserId(id));
		
	}
	
}
