package com.chat.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
	public User joinUser(@RequestBody User user) {
		return userService.AddUser(user);
	}
	@GetMapping("/all")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
}
