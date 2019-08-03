package com.topica.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.topica.entity.User;
import com.topica.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	

	@GetMapping("/api/user/{id}")
	public Optional<User> findById(@PathVariable Long id) {
		Optional<User> user = null;
		if (id != null) {
			user = userService.findById(id);
		}
		return user;
	}

	@PostMapping("/api/user/save")
	public User saveUser(@RequestBody User user) {
			user = userService.saveUser(user);
		return user;
	}

	@GetMapping("/api/user/list")
	public List<User> findAll() {
		Pageable pageable = PageRequest.of(1, 2);
		return userService.findAllUser(pageable).getContent();
	}

	@GetMapping("/api/user/delete/{id}")
	public List<User> deleteUser(@PathVariable Long id) {
		Pageable pageable = PageRequest.of(1, 2);
		if(id != null) {
			userService.deleteUser(id);
		}
		return userService.findAllUser(pageable).getContent();
	}
	
	@GetMapping("/api/user")
	public List<User> findByRole(@RequestParam String role) {
		List<User> users = null;
		if (role != null) {
			users = userService.findByRole(role);
		}
		return users;
	}
}
