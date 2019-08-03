package com.topica.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.topica.entity.User;

@Repository
public class UserDaoImpl {
	
	@Autowired
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<User> findByRole(String role){
		Query query = entityManager.createQuery("From User as u where u.role = :role");
		query.setParameter("role", role);
		return query.getResultList();
	}
	
	public User getOne(Long id){
		Query query = entityManager.createQuery("From User as u where u.id = :id");
		query.setParameter("id", id);
		return (User) query.getResultList().get(0);
	}
}
