package com.topica.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CLASSROOM")
public class Classroom {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name= "COURSEID")
	private Long courseId;
	
	@Column(name= "TEACHERID")
	private Long teacherId;
	
	@Column(name= "KIDID")
	private Long kidId;
	
	@Column(name= "STARTTIME")
	private Timestamp startTime;
	
	@Column(name= "STATUS")
	private String status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public Long getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Long teacherId) {
		this.teacherId = teacherId;
	}

	public Long getKidId() {
		return kidId;
	}

	public void setKidId(Long kidId) {
		this.kidId = kidId;
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

	public Classroom(Long id, Long courseId, Long teacherId, Long kidId, Timestamp startTime, String status) {
		super();
		this.id = id;
		this.courseId = courseId;
		this.teacherId = teacherId;
		this.kidId = kidId;
		this.startTime = startTime;
		this.status = status;
	}

	public Classroom() {
		super();
	}

	@Override
	public String toString() {
		return "Classroom [id=" + id + ", courseId=" + courseId + ", teacherId=" + teacherId + ", kidId=" + kidId
				+ ", startTime=" + startTime + ", status=" + status + "]";
	}
	
	
}
