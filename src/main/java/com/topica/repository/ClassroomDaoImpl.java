package com.topica.repository;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.topica.entity.Classroom;

@Repository
public class ClassroomDaoImpl {
	
	@Autowired
	private EntityManager entityManager;
	
	public Classroom getOne(Long id) {
		Query query = entityManager.createQuery("From Classroom as c where c.id = :id");
		query.setParameter("id", id);
		return (Classroom) query.getResultList().get(0);
	}
	
	public void deleteByUserId(Long id) {
		Query query = entityManager.createQuery("Delete Classroom as c where c.id = :id");
		query.setParameter("id", id);
		query.executeUpdate();
	}
	
	@SuppressWarnings("unchecked")
	public List<Classroom> getByUserId(Long id) {
		Query query = entityManager.createQuery("FROM Classroom as c where c.kidId = :id");
		query.setParameter("id", id);
		return query.getResultList();
	}
	
	@Transactional
	public void changeStatus(Long id, Timestamp time) {
		Query query = entityManager.createQuery("UPDATE Classroom as c SET c.status = 'happened', c.startTime = :time where c.id = :id");
		query.setParameter("id", id);
		query.setParameter("time", time);
		query.executeUpdate();
	}
	 
	@SuppressWarnings("unchecked")
	public List<Classroom> getByTime(Timestamp time) {
		Query query = entityManager.createQuery("FROM Classroom as c where (c.status = 'happening') or (c.status = 'happened' and c.startTime > :time) ");
		query.setParameter("time", time);
		return query.getResultList();
	}
}
