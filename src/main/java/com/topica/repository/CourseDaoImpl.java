package com.topica.repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

import com.topica.entity.Course;


public class CourseDaoImpl {
	@Autowired
	private EntityManager entityManager;
	
	public Course getOne(Long id){
		Query query = entityManager.createQuery("From Course as c where c.id = :id");
		query.setParameter("id", id);
		return (Course) query.getResultList().get(0);
	}
}
