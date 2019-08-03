package com.topica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.topica.entity.Course;


public interface CourseDao extends JpaRepository<Course, Long> {

}
