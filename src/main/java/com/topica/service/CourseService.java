package com.topica.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.topica.entity.Course;
import com.topica.repository.CourseDao;
import com.topica.repository.CourseDaoImpl;

@Service
public class CourseService {
	
	@Autowired
	private CourseDao courseDao;
	
	@Autowired
	private CourseDaoImpl courseDaoImpl;
	
	public Course saveCourse(Course course ) {
		return courseDao.save(course);
	}
	
	public void deleteCourse (Long id) {
		courseDao.deleteById(id);
	}
	
	public Optional<Course> findById(Long id) {
		return courseDao.findById(id);
	}
	
	public List<Course> findAllCourse() {
		return courseDao.findAll();
	}
	
	public Course getOne(Long id) {
		return courseDaoImpl.getOne(id);
	}

}
