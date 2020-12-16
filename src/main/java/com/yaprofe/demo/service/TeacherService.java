package com.yaprofe.demo.service;

import java.util.List;

import com.yaprofe.demo.model.Profesor;

public interface TeacherService {
	List <Profesor> listAll();
	void save (Profesor profesor);
	void delete (int id);
	Profesor getId (int id);
	Profesor findByEmail (String email);
	Profesor findByNombres (String nombres);
}
