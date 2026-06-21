package com.chat.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chat.app.model.User;
import com.chat.app.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping("/join")
	public ResponseEntity<User> joinUser(@RequestBody User user) {
		User users = userService.addUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(users);
	}
	
	
	@GetMapping("/all")
	public ResponseEntity<List<User>> getAllUsers(){
		List <User> users = userService.getAllUsers();
		return ResponseEntity.ok(users);
	}
	
	@DeleteMapping("/leave/{name}")
	public ResponseEntity<String> leaveUser(@PathVariable String name){
		 userService.removeUser(name);
		
		return ResponseEntity.ok("User removed successfully");
	}
}
