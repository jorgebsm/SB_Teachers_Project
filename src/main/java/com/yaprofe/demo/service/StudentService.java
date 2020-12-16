package com.yaprofe.demo.service;

import java.util.List;

import com.yaprofe.demo.model.Estudiante;

public interface StudentService {
	List <Estudiante> listAll();
	void save (Estudiante estudiante);
	void delete (int id);
	Estudiante getId (int id);
}
