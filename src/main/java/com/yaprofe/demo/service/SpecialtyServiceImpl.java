package com.yaprofe.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yaprofe.demo.model.Especialidad;
import com.yaprofe.demo.repository.SpecialtyRepository;

@Service
public class SpecialtyServiceImpl implements SpecialtyService{

	@Autowired
	private SpecialtyRepository specialtyRepository;
	
	@Override
	public List<Especialidad> listAll() {
		return specialtyRepository.findAll();
	}

	@Override
	public void save(Especialidad especialidad) {
		specialtyRepository.save(especialidad);
	}

	@Override
	public void delete(int id) {
		specialtyRepository.deleteById(id);
		
	}

	@Override
	public Especialidad getId(int id) {
		// TODO Auto-generated method stub
		return specialtyRepository.findById(id).get();
	}

}
