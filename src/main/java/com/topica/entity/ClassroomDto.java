package com.topica.entity;

import java.sql.Timestamp;

public class ClassroomDto {

	private Long id;
	private String teacherName;
	private String courseName;
	private Timestamp startTime;
	private String status;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public Timestamp getStartTime() {
		return startTime;
	}
	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public ClassroomDto(Long id, String teacherName, String courseName, Timestamp startTime, String status) {
		super();
		this.id = id;
		this.teacherName = teacherName;
		this.courseName = courseName;
		this.startTime = startTime;
		this.status = status;
	}
	public ClassroomDto() {
		super();
	}
	
	
}
