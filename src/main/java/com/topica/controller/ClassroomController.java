package com.topica.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.topica.entity.Classroom;
import com.topica.entity.ClassroomDto;
import com.topica.service.ClassroomService;
import com.topica.service.CourseService;
import com.topica.service.UserService;

@RestController
public class ClassroomController {
	
	@Autowired
	private ClassroomService classroomService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/api/classroom/list")
	public List<Classroom> findAll() {
		return classroomService.findAllClassroom();
	}
	
	@GetMapping("/api/classroom/{id}")
	public Optional<Classroom> findById(@RequestParam("id") Long id) {
		Optional<Classroom> classroom = null;
		if(id != null) {
			classroom = classroomService.findById(id);
		}
		return classroom;
	}
	
	@PostMapping("/api/classroom/save")
	public Classroom saveClassroom(@RequestBody Classroom classroom) {
		if (classroom != null) {
			classroom = classroomService.saveClassroom(classroom);
		}
		return classroom;
	}
	
	@GetMapping("/api/classroom/delete/{id}")
	public List<Classroom> deleteClassroom(@PathVariable Long id) {
		if(id != null) {
			classroomService.deleteClassroom(id);
		}
		return classroomService.findAllClassroom();
	}
	
	@GetMapping("/api/classroom/changeStatus/{id}")
	public Classroom changeStatus(@PathVariable Long id) {
		Classroom classroom = classroomService.getOne(id);
		if(id != null && !classroom.getStatus().equals("happened")) {
			classroom = classroomService.changeStatus(id);
		}
		return classroom;
	}
	
	@GetMapping("/api/classroom/list/user/{id}")
	public List<ClassroomDto> getListClassByUser(@PathVariable Long id) {
		List<Classroom> classrooms = null;
		List<ClassroomDto> classroomDtos = new ArrayList<ClassroomDto>();
		if(id != null) {
			classrooms = classroomService.findClassByUserId(id);
		}
		if (classrooms != null) {
			for (Classroom classroom : classrooms) {
				String teacherName = userService.getOne(classroom.getTeacherId()).getName();
				String courseName = courseService.getOne(classroom.getCourseId()).getName();
				ClassroomDto classroomDto = new ClassroomDto(classroom.getId(), teacherName, courseName, classroom.getStartTime(), classroom.getStatus());
				classroomDtos.add(classroomDto);
			}
		}
		return classroomDtos;
	}
	
	@GetMapping("/api/classroom/list/time/{time}")
	public List<Classroom> getlistClassByTime(@PathVariable Long time) {
		List<Classroom> classrooms = null;
		if(time != null) {
			classrooms = classroomService.findClassByTime(time);
		}
		return classrooms;
	}
}
