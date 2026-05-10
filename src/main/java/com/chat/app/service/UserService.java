package com.chat.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.chat.app.model.User;

@Service
public class UserService {
	private List<User> users = new ArrayList<>();
	
	public User AddUser(User user) {
		users.add(user);
		return user;
	}
	
	public List<User> getAllUsers(){
		return users;
	}

	public boolean userExists(String name) {
		for(User user : users) {
			if(user.getName().equals(name)) {
				return true;
			}
		}
		return false;
	}
}
