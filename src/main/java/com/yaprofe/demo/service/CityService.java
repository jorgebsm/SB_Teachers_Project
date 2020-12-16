package com.yaprofe.demo.service;

import java.util.List;

import com.yaprofe.demo.model.Ciudad;

public interface CityService {
	List <Ciudad> listAll();
	void save (Ciudad ciudad);
	void delete (int id);
	Ciudad getId (int id);
}

