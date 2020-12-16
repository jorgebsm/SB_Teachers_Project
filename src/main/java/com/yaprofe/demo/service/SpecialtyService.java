package com.yaprofe.demo.service;

import java.util.List;
import com.yaprofe.demo.model.Especialidad;

public interface SpecialtyService {
	List <Especialidad> listAll();
	void save (Especialidad especialidad);
	void delete (int id);
	Especialidad getId (int id);
}