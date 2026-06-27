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
	
	public UserResponse getCurrentUser(String username) {

	    User user = userRepository.findByUsername(username)
	            .orElseThrow(() ->
	                    new UserNotFoundException("User not found"));

	    return new UserResponse(
	            user.getId(),
	            user.getUsername(),
	            user.getRole()
	    );
	}
	
	public List<UserResponse> getAllUsers() {

	    List<User> users = userRepository.findAll();

	    return users.stream()
	            .map(user -> new UserResponse(
	                    user.getId(),
	                    user.getUsername(),
	                    user.getRole()))
	            .toList();
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
