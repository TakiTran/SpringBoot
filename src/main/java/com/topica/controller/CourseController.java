package com.topica.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.topica.entity.Course;
import com.topica.service.CourseService;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/api/course/{id}")
	public Optional<Course> findById(@PathVariable Long id) {
		Optional<Course> course = null;
		if (id != null) {
			course = courseService.findById(id);
		}
		return course;
	}

	@PostMapping("/api/course/save")
	public Course savecourse(@RequestBody Course course) {
		if (course != null) {
			course = courseService.saveCourse(course);
		}
		return course;
	}

	@GetMapping("/api/course/list")
	public Page<Course> findAll(@RequestParam int pageNumber) {
		Pageable pageable = PageRequest.of(pageNumber, 2);
		return courseService.findAllCourse(pageable);
	}
	
	@GetMapping("/api/course")
	public List<Course> findAll() {
		return courseService.findAll();
	}

	@GetMapping("/api/course/delete/{id}")
	public Page<Course> deletecourse(@PathVariable Long id) {
		if(id != null) {
			courseService.deleteCourse(id);
		}
		Pageable pageable = PageRequest.of(0, 2);
		return courseService.findAllCourse(pageable);
	}
}
