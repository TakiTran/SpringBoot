package com.topica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.topica.entity.User;

public interface UserDao extends JpaRepository<User, Long> {

}
