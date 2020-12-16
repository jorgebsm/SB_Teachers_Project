package com.yaprofe.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yaprofe.demo.model.Profesor;

@Repository
public interface TeacherRepository extends JpaRepository<Profesor,Integer>{
	Profesor findByEmail(String email);
	Profesor findByNombres(String nombres);
}
