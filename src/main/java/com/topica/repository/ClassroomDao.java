package com.topica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.topica.entity.Classroom;

@Repository
public interface ClassroomDao extends JpaRepository<Classroom, Long> {

}
