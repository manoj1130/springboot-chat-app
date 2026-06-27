package com.chat.app.service;
import com.chat.app.dto.UserRequest;
import com.chat.app.dto.UserResponse;
import com.chat.app.exception.UserNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.chat.app.model.User;
import com.chat.app.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public UserResponse addUser(UserRequest request) {
		User user = new User();
		user.setUsername(request.getUsername());
		user.setPassword(passwordEncoder.encode(request.getPassword()));
		user.setRole(request.getRole());
		
		User savedUser = userRepository.save(user);
		return new UserResponse(
				savedUser.getId(),
				savedUser.getUsername(),
				savedUser.getRole());
	}
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}

	public boolean userExists(String name) {
		return userRepository.existsByUsername(name);
	}
	
	
	public boolean removeUser(String name) {
		
		if(!userRepository.existsByUsername(name)) {
			throw new UserNotFoundException("User '"+name+ "' not found.");
		}
		userRepository.deleteByUsername(name);
		return true;
		
	}
}
