package com.topica.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.topica.entity.Classroom;
import com.topica.repository.ClassroomDao;
import com.topica.repository.ClassroomDaoImpl;

@Service
public class ClassroomService {
	
	@Autowired
	private ClassroomDao classroomDao;
	
	@Autowired
	private ClassroomDaoImpl classroomDaoImpl;

	public Classroom saveClassroom(Classroom classroom ) {
		return classroomDao.save(classroom);
	}
	
	public void deleteClassroom (Long id) {
		classroomDao.deleteById(id);
	}
	
	
	public Optional<Classroom> findById(Long id) {
		return classroomDao.findById(id);
	}
	
	public Page<Classroom> findAllClassroom(Pageable pageable) {
		return classroomDao.findAll(pageable);
	}
	
	public Classroom getOne(Long id) {
		return classroomDaoImpl.getOne(id);
	} 
	
	public void deleteByUserId(Long id) {
		classroomDaoImpl.deleteByUserId(id);
	}
	
	public void deleteByCourseId(Long id) {
		classroomDaoImpl.deleteByCourseId(id);
	}
	
	public List<Classroom> findClassByUserId(Long id) {
		return  classroomDaoImpl.getByUserId(id);
	}
	
	public List<Classroom> findClassByTime(Long number) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis() - number*60*1000);
		return classroomDaoImpl.getByTime(timestamp);
	}
	
	public Classroom changeStatus(Long id) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		classroomDaoImpl.changeStatus(id, timestamp);
		return classroomDaoImpl.getOne(id);
	}
	
}
