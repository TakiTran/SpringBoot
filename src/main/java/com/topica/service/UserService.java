package com.topica.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.topica.entity.User;
import com.topica.repository.UserDao;
import com.topica.repository.UserDaoImpl;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private UserDaoImpl userDaoImpl;
	
	@Autowired
	private ClassroomService classroomService;
	
	public Optional<User> findById(Long id) {
		return userDao.findById(id);
	}
	
	public User saveUser(User user) {
		return userDao.save(user);
	}
	
	public void deleteUser (Long id) {
		classroomService.deleteByUserId(id);
		userDao.deleteById(id);
	}
	
	public Page<User> findAllUser(Pageable pageable) {
		return userDao.findAll(pageable);
	}
	
	public List<User> findByRole(String role) {
		return userDaoImpl.findByRole(role);
	}
	
	public User getOne(Long id) {
		return userDaoImpl.getOne(id);
	}
}
