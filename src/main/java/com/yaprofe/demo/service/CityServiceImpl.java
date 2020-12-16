package com.yaprofe.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yaprofe.demo.model.Ciudad;
import com.yaprofe.demo.repository.CityRepository;

@Service
public class CityServiceImpl implements CityService{

	@Autowired
	private CityRepository cityRepository;
	
	@Override
	public List<Ciudad> listAll() {
		return cityRepository.findAll();
	}

	@Override
	public void save(Ciudad ciudad) {
		cityRepository.save(ciudad);
	}

	@Override
	public void delete(int id) {
		cityRepository.deleteById(id);
		
	}

	@Override
	public Ciudad getId(int id) {
		// TODO Auto-generated method stub
		return cityRepository.findById(id).get();
	}

}
