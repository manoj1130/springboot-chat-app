package com.chat.app.service;
import com.chat.app.exception.UserNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chat.app.exception.UserNotFoundException;
import com.chat.app.model.User;
import com.chat.app.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public User addUser(User user) {
		return userRepository.save(user);
	}
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}

	public boolean userExists(String name) {
		return userRepository.existsByName(name);
	}
	
	
	public boolean removeUser(String name) {
		
		if(!userRepository.existsByName(name)) {
			throw new UserNotFoundException("User '"+name+ "' not found.");
		}
		userRepository.deleteByName(name);
		return true;
		
	}
}
